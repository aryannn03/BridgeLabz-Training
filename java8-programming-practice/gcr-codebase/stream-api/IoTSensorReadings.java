import java.util.*;
import java.util.stream.*;

public class IoTSensorReadings{
    public static void main(String[] args){
        List<Double> readings=Arrays.asList(
            22.5,
            35.8,
            18.2,
            40.1,
            27.6
        );

        double threshold=30.0;

        readings.stream()
            .filter(r->r>threshold)
            .forEach(r->System.out.println(r));
    }
}
