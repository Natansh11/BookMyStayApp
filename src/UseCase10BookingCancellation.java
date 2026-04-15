import java.util.*;

class CancellationService {
    private Stack<String> cancelledRooms = new Stack<>();
    private Map<String, Integer> inventory = new HashMap<>();

    public CancellationService() {
        inventory.put("Deluxe", 5);
    }

    public void cancel(String roomType, String roomId) {
        cancelledRooms.push(roomId);
        inventory.put(roomType, inventory.get(roomType) + 1);
        System.out.println("Cancelled: " + roomId);
    }

    public void showInventory() {
        System.out.println(inventory);
    }
}

public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        CancellationService service = new CancellationService();

        service.cancel("Deluxe", "D101");
        service.showInventory();
    }
}