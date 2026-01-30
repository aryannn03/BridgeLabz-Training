import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest{
    BankAccount b=new BankAccount();

    @Test
    void testDeposit(){
        b.deposit(500);
        assertEquals(500,b.getBalance());
    }

    @Test
    void testWithdraw(){
        b.deposit(1000);
        b.withdraw(300);
        assertEquals(700,b.getBalance());
    }

    @Test
    void testWithdrawInsufficientBalance(){
        b.deposit(200);
        assertThrows(IllegalArgumentException.class,()->b.withdraw(500));
    }
}
