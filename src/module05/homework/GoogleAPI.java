package module05.homework;

import java.util.Date;

public class GoogleAPI implements API {

    private static Room[] rooms = new Room[5];

    public GoogleAPI() {
        rooms[0] = new Room(31111L, 400, 2, new Date("2016/09/29 12:00:00"), "Flagman", "Lvov");
        rooms[1] = new Room(31112L, 320, 2, new Date("2016/09/18 12:00:00"), "Dolphin", "Zatoka");
        rooms[2] = new Room(31113L, 250, 2, new Date("2016/09/18 12:00:00"), "Mukachevo", "Mukachevo");
        rooms[3] = new Room(31114L, 600, 4, new Date("2016/09/18 12:00:00"), "Zolotoy", "Zheleznyi Port");
        rooms[4] = new Room(31115L, 500, 2, new Date("2016/09/18 12:00:00"), "Fontan", "Odessa");
    }

    @Override
    public Room[] getAllRooms() {
        return rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        Room requestedRoom = new Room(0L, price, persons, new Date(), hotel, city);
        Room[] tempRooms = new Room[rooms.length];
        int index = 0;

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(requestedRoom)) {
                tempRooms[index] = rooms[i];
                index++;
            }
        }

        Room[] foundRooms;

        if (index == 0) {
            return new Room[0];
        } else {
            foundRooms = new Room[index];
        }

        for (int i = index - 1; i >= 0; i--) {
            foundRooms[i] = tempRooms[i];
        }
        return foundRooms;
    }

}
