public class RoomSearchService {

    public void searchAvailableRooms(RoomInventory inventory,
                                     Room single,
                                     Room doubleRoom,
                                     Room suite) {

        var availability = inventory.getRoomAvailability();

        System.out.println("\n--- Available Rooms ---");

        if (availability.get("Single") > 0) {
            System.out.println("Single Room:");
            single.displayRoomDetails();
        }

        if (availability.get("Double") > 0) {
            System.out.println("Double Room:");
            doubleRoom.displayRoomDetails();
        }

        if (availability.get("Suite") > 0) {
            System.out.println("Suite Room:");
            suite.displayRoomDetails();
        }
    }
}