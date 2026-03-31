import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest{
    NumberUtils n=new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints={2,4,6})
    void testEvenNumbers(int value){
        assertTrue(n.isEven(value));
    }

    @ParameterizedTest
    @ValueSource(ints={7,9})
    void testOddNumbers(int value){
        assertFalse(n.isEven(value));
    }
}
