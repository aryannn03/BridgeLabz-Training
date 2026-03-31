import java.util.*;

class InsufficientResourceException extends Exception {
    public InsufficientResourceException(String message) {
        super(message);
    }
}

class AreaRequest {
    String areaName;
    String item;
    int quantity;

    public AreaRequest(String areaName, String item, int quantity) {
        this.areaName = areaName;
        this.item = item;
        this.quantity = quantity;
    }
}

class ReliefCenter {
    String name;
    HashMap<String, Integer> resources = new HashMap<>();
    Queue<AreaRequest> requests = new LinkedList<>();
    List<String> report = new ArrayList<>();

    public ReliefCenter(String name) {
        this.name = name;
    }

    public void addResource(String item, int quantity) {
        resources.put(item, resources.getOrDefault(item, 0) + quantity);
    }

    public void addRequest(AreaRequest request) {
        requests.offer(request);
    }

    public void allocate() throws InsufficientResourceException {
        while (!requests.isEmpty()) {
            AreaRequest request = requests.poll();
            int available = resources.getOrDefault(request.item, 0);
            if (available < request.quantity) {
                throw new InsufficientResourceException("Insufficient " + request.item + " for " + request.areaName);
            }
            resources.put(request.item, available - request.quantity);
            report.add("Allocated " + request.quantity + " " + request.item + " to " + request.areaName);
        }
    }

    public void generateReport() {
        for (String r : report) {
            System.out.println(r);
        }
    }
}

public class DisasterReliefResourceAllocationSystem {
    public static void main(String[] args) {
        Map<String, ReliefCenter> centers = new HashMap<>();

        ReliefCenter center = new ReliefCenter("Center1");
        center.addResource("Food", 100);
        center.addResource("Water", 200);
        center.addResource("MedicalKit", 50);

        center.addRequest(new AreaRequest("AreaA", "Food", 30));
        center.addRequest(new AreaRequest("AreaB", "Water", 50));
        center.addRequest(new AreaRequest("AreaC", "MedicalKit", 20));

        centers.put(center.name, center);

        try {
            center.allocate();
            center.generateReport();
        } catch (InsufficientResourceException e) {
            System.out.println(e.getMessage());
        }
    }
}
