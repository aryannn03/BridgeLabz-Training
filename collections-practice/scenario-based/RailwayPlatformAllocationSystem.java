import java.util.*;

class PlatformUnavailableException extends Exception {
    public PlatformUnavailableException(String message) {
        super(message);
    }
}

class Train implements Comparable<Train> {
    private String trainId;
    private int arrivalTime;

    public Train(String trainId, int arrivalTime) {
        this.trainId = trainId;
        this.arrivalTime = arrivalTime;
    }

    public String getTrainId() {
        return trainId;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int compareTo(Train t) {
        return this.arrivalTime - t.arrivalTime;
    }
}

class Platform {
    private int platformNumber;
    private boolean occupied;

    public Platform(int platformNumber) {
        this.platformNumber = platformNumber;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void assignTrain(Train train) throws PlatformUnavailableException {
        if (occupied) {
            throw new PlatformUnavailableException("Platform " + platformNumber + " unavailable");
        }
        occupied = true;
        System.out.println("Train " + train.getTrainId() + " allocated to Platform " + platformNumber);
    }

    public void release() {
        occupied = false;
    }
}

public class RailwayPlatformAllocationSystem {
    public static void main(String[] args) {
        Map<Integer, Platform> platforms = new HashMap<>();
        platforms.put(1, new Platform(1));
        platforms.put(2, new Platform(2));

        PriorityQueue<Train> incomingTrains = new PriorityQueue<>();
        incomingTrains.add(new Train("T1", 900));
        incomingTrains.add(new Train("T2", 830));
        incomingTrains.add(new Train("T3", 1000));

        while (!incomingTrains.isEmpty()) {
            Train train = incomingTrains.poll();
            boolean allocated = false;
            for (int key : new TreeSet<>(platforms.keySet())) {
                Platform platform = platforms.get(key);
                if (!platform.isOccupied()) {
                    try {
                        platform.assignTrain(train);
                        allocated = true;
                        break;
                    } catch (PlatformUnavailableException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            if (!allocated) {
                System.out.println("No platform available for Train " + train.getTrainId());
            }
        }
    }
}
