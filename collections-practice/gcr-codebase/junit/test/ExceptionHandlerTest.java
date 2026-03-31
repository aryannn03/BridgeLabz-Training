import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlerTest{
    ExceptionHandler e=new ExceptionHandler();

    @Test
    void testDivideByZero(){
        assertThrows(ArithmeticException.class,()->e.divide(10,0));
    }
}
