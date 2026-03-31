import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest{
    Calculator c=new Calculator();

    @Test
    void testAdd(){
        assertEquals(7,c.add(3,4));
    }

    @Test
    void testSubtract(){
        assertEquals(3,c.subtract(5,2));
    }

    @Test
    void testMultiply(){
        assertEquals(20,c.multiply(4,5));
    }

    @Test
    void testDivide(){
        assertEquals(5,c.divide(10,2));
    }

    @Test
    void testDivideByZero(){
        assertThrows(ArithmeticException.class,()->c.divide(10,0));
    }
}
