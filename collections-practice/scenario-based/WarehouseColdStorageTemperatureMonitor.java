import java.util.*;

class SensorFailureException extends Exception {
    public SensorFailureException(String message) {
        super(message);
    }
}

class TemperatureLog {
    private List<Double> readings = new ArrayList<>();
    private double minSafe;
    private double maxSafe;

    public TemperatureLog(double minSafe, double maxSafe) {
        this.minSafe = minSafe;
        this.maxSafe = maxSafe;
    }

    public void addReading(double temp) throws SensorFailureException {
        if (temp < -100 || temp > 100) {
            throw new SensorFailureException("Sensor failure detected");
        }
        readings.add(temp);
        if (temp < minSafe || temp > maxSafe) {
            System.out.println("Alert: Temperature out of safe range");
        }
    }

    public double calculateDailyAverage() {
        if (readings.isEmpty()) return 0.0;
        double sum = 0;
        for (double t : readings) {
            sum += t;
        }
        return sum / readings.size();
    }
}

public class WarehouseColdStorageTemperatureMonitor {
    public static void main(String[] args) {
        Map<String, TemperatureLog> rooms = new HashMap<>();

        TemperatureLog room1 = new TemperatureLog(2.0, 8.0);
        rooms.put("R1", room1);

        try {
            room1.addReading(4.5);
            room1.addReading(7.0);
            room1.addReading(9.5);
            System.out.println(room1.calculateDailyAverage());
        } catch (SensorFailureException e) {
            System.out.println(e.getMessage());
        }
    }
}
