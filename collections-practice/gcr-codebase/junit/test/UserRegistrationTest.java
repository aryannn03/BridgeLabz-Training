import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest{
    UserRegistration u=new UserRegistration();

    @Test
    void testValidRegistration(){
        assertTrue(u.registerUser("john","john@gmail.com","Password1"));
    }

    @Test
    void testInvalidUsername(){
        assertThrows(IllegalArgumentException.class,()->u.registerUser("","john@gmail.com","Password1"));
    }

    @Test
    void testInvalidEmail(){
        assertThrows(IllegalArgumentException.class,()->u.registerUser("john","johngmail.com","Password1"));
    }

    @Test
    void testInvalidPassword(){
        assertThrows(IllegalArgumentException.class,()->u.registerUser("john","john@gmail.com","pass"));
    }
}
