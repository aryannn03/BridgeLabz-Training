import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest{
    PasswordValidator p=new PasswordValidator();

    @Test
    void testValidPassword(){
        assertTrue(p.isValid("Password1"));
    }

    @Test
    void testTooShortPassword(){
        assertFalse(p.isValid("Pass1"));
    }

    @Test
    void testNoUppercase(){
        assertFalse(p.isValid("password1"));
    }

    @Test
    void testNoDigit(){
        assertFalse(p.isValid("Password"));
    }
}
