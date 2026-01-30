import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTaskTest{
    PerformanceTask p=new PerformanceTask();

    @Test
    @Timeout(2)
    void testLongRunningTaskTimeout() throws InterruptedException{
        assertEquals("Done",p.longRunningTask());
    }
}
