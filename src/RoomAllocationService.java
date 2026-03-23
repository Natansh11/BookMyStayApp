import java.util.*;

public class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRooms;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRooms = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String type = reservation.getRoomType();
        int available = inventory.getRoomAvailability().get(type);

        if (available <= 0) {
            System.out.println("No rooms available for " + type);
            return;
        }

        String roomId = generateRoomId(type);

        allocatedRoomIds.add(roomId);

        assignedRooms.putIfAbsent(type, new HashSet<>());
        assignedRooms.get(type).add(roomId);

        inventory.updateAvailability(type, available - 1);

        System.out.println("\nRoom Allocated!");
        System.out.println("Guest: " + reservation.getGuestName());
        System.out.println("Room Type: " + type);
        System.out.println("Room ID: " + roomId);
    }

    private String generateRoomId(String type) {
        return type.substring(0, 1).toUpperCase()
                + "_" + UUID.randomUUID().toString().substring(0, 5);
    }
}