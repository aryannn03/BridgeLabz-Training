import java.util.*;
import java.util.stream.*;

public class StockPriceLogger{
    public static void main(String[] args){
        List<Double> stockPrices=Arrays.asList(
            1520.50,
            1532.75,
            1510.20,
            1545.90,
            1550.10
        );

        stockPrices.stream()
            .forEach(price->System.out.println(price));
    }
}
