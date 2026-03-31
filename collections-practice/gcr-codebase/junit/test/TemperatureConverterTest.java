import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest{
    TemperatureConverter t=new TemperatureConverter();

    @Test
    void testCelsiusToFahrenheit(){
        assertEquals(32.0,t.celsiusToFahrenheit(0),0.001);
        assertEquals(212.0,t.celsiusToFahrenheit(100),0.001);
    }

    @Test
    void testFahrenheitToCelsius(){
        assertEquals(0.0,t.fahrenheitToCelsius(32),0.001);
        assertEquals(100.0,t.fahrenheitToCelsius(212),0.001);
    }
}
