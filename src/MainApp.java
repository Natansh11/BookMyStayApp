public class MainApp {
    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay - Hotel Booking System");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Search available rooms
        RoomSearchService search = new RoomSearchService();
        search.searchAvailableRooms(inventory, single, doubleRoom, suite);

        // Booking queue
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Natansh", "Single"));
        queue.addRequest(new Reservation("Rahul", "Double"));
        queue.addRequest(new Reservation("Aman", "Suite"));

        // Allocation
        RoomAllocationService allocator = new RoomAllocationService();

        while (queue.hasRequests()) {
            Reservation r = queue.getNextRequest();
            allocator.allocateRoom(r, inventory);
        }
    }
}