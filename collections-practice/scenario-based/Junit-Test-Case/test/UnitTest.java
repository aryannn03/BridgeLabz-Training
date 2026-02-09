import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    @Test
    public void testDepositValidAmount(){
        Program account=new Program(100);

        account.deposit(50);

        assertEquals(150,account.getBalance());
    }
    @Test
    public void testDepositNegativeAmount(){
        Program account=new Program(100);

        Exception ex=assertThrows(
            IllegalArgumentException.class,
            ()->account.deposit(-20)
        );

        assertEquals("Deposit amount cannot be negative",ex.getMessage());
    }

    @Test
    public void testWithdrawValidAmount(){
        Program account=new Program(200);

        account.withdraw(80);

        assertEquals(120,account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds(){
        Program account=new Program(100);

        Exception ex=assertThrows(
            IllegalArgumentException.class,
            ()->account.withdraw(150)
        );

        assertEquals("Insufficient funds",ex.getMessage());
    }
}
