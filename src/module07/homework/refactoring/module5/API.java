package module07.homework.refactoring.module5;

import java.util.List;

public interface API {

    List<Room> findRooms(int price, int persons, String city, String hotel);

    List<Room> getAllRooms();

}
