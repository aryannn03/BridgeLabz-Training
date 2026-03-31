import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest{
    ListManager m=new ListManager();

    @Test
    void testAddElement(){
        List<Integer> list=new ArrayList<>();
        m.addElement(list,10);
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement(){
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        m.removeElement(list,10);
        assertFalse(list.contains(10));
    }

    @Test
    void testGetSize(){
        List<Integer> list=new ArrayList<>();
        m.addElement(list,10);
        m.addElement(list,20);
        assertEquals(2,m.getSize(list));
    }
}
