import java.util.*;
class BankAccount{
    int accountNumber;
    double balance;
    BankAccount(int accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
    void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposited:"+amount);
        }else{
            System.out.println("Invalid deposit amount");
        }
    }
    void withdraw(double amount){
        if(amount<=0){
            System.out.println("Invalid withdraw amount");
        }else if(amount>balance){
            System.out.println("Insufficient balance");
        }else{
            balance-=amount;
            System.out.println("Withdrawn:"+amount);
        }
    }
    void checkBalance(){
        System.out.println("Current Balance:"+balance);
    }
}
public class BankAccountManager{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter account number:");
        int accNo=scanner.nextInt();
        System.out.print("Enter initial balance:");
        double bal=scanner.nextDouble();
        BankAccount account=new BankAccount(accNo,bal);
        account.checkBalance();
        System.out.print("Enter amount to deposit:");
        account.deposit(scanner.nextDouble());
        account.checkBalance();
        System.out.print("Enter amount to withdraw:");
        account.withdraw(scanner.nextDouble());
        account.checkBalance();
    }
}