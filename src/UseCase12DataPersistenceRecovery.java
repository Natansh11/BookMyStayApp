import java.io.*;
import java.util.*;

class FilePersistenceService {

    public void save(Map<String, Integer> inventory, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (String key : inventory.keySet()) {
            writer.write(key + "=" + inventory.get(key));
            writer.newLine();
        }
        writer.close();
    }

    public Map<String, Integer> load(String filePath) throws IOException {
        Map<String, Integer> inventory = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=");
            inventory.put(parts[0], Integer.parseInt(parts[1]));
        }
        reader.close();
        return inventory;
    }
}

public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) throws Exception {
        FilePersistenceService service = new FilePersistenceService();

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Deluxe", 5);

        service.save(inventory, "data.txt");

        Map<String, Integer> loaded = service.load("data.txt");
        System.out.println("Loaded: " + loaded);
    }
}