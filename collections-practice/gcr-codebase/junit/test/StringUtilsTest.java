import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest{
    StringUtils s=new StringUtils();

    @Test
    void testReverse(){
        assertEquals("avaj",s.reverse("java"));
    }

    @Test
    void testPalindromeTrue(){
        assertTrue(s.isPalindrome("madam"));
    }

    @Test
    void testPalindromeFalse(){
        assertFalse(s.isPalindrome("java"));
    }

    @Test
    void testToUpperCase(){
        assertEquals("BRIDGELABZ",s.toUpperCase("bridgeLabz"));
    }
}
