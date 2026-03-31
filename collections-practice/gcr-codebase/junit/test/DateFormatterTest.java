import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.format.DateTimeParseException;

public class DateFormatterTest{
    DateFormatter d=new DateFormatter();

    @Test
    void testValidDate(){
        assertEquals("15-01-2024",d.formatDate("2024-01-15"));
    }

    @Test
    void testAnotherValidDate(){
        assertEquals("31-12-2023",d.formatDate("2023-12-31"));
    }

    @Test
    void testInvalidDate(){
        assertThrows(DateTimeParseException.class,()->d.formatDate("15-01-2024"));
    }

    @Test
    void testWrongFormat(){
        assertThrows(DateTimeParseException.class,()->d.formatDate("2024/01/15"));
    }
}
