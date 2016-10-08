package module07.homework.refactoring.module5;

import java.util.*;

public class Controller {

    private Map<String, API> apis;

    public Controller() {
        this.apis = new TreeMap<>();
        apis.put("google", new GoogleAPI());
        apis.put("bookingCom", new BookingComAPI());
        apis.put("tripAdvisor", new TripAdvisorAPI());
    }

    public List<Room> requestRooms(int price, int persons, String city, String hotel) {
        List<Room> result = new ArrayList<>();
        DAO dao = new DAOImpl();
        Iterator<Map.Entry<String, API>> apisIterator = apis.entrySet().iterator();
        while (apisIterator.hasNext()){
            API api = apisIterator.next().getValue();
            List<Room> foundRooms = api.findRooms(price, persons, city, hotel);
            result.addAll(foundRooms);
            result.forEach(dao::save);
        }
        if (result.size() == 0) {
            System.out.println("Sorry but rooms with the requested criteria have not been found.");
        } else {
            System.out.println("\n" + result.size() + " rooms With the requested criteria were found.");
        }
        return result;
    }

    public List<Room> check(API api1, API api2) {
        List<Room> result = new ArrayList<>();

        result.addAll(api1.getAllRooms());
        result.retainAll(api2.getAllRooms());

        System.out.println("\n" + result.size() + " matches have been found.");
        return result;
    }

    public Map<String, API> getApis() {
        return apis;
    }
}
