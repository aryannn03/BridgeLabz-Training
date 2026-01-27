import java.util.*;
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
public class BankAccount {
    private double balance=5000;
    public void withdraw(double amount)throws InsufficientBalanceException {
        if(amount<0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if(amount>balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance-=amount;
        System.out.println("Withdrawal successful, new balance:"+balance);
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the amount to withdraw:");
        double amount=ob.nextDouble();
        BankAccount account=new BankAccount();
        try {
            account.withdraw(amount);
        } catch(InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}