interface Loanable{
    void applyForLoan();
    boolean calculateLoanEligibility();
}
abstract class BankAccount{
    private String accountNumber;
    private String holderName;
    protected double balance;
    BankAccount(String acc,String name,double bal){
        accountNumber=acc;
        holderName=name;
        balance=bal;
    }
    void deposit(double amount){
        if(amount>0)
            balance+=amount;
    }
    void withdraw(double amount){
        if(amount<=balance)
            balance-=amount;
    }
    abstract double calculateInterest();
    void getAccountDetails(){
        System.out.println("Account:"+accountNumber);
        System.out.println("Holder:"+holderName);
        System.out.println("Balance:"+balance);
    }
}
class SavingsAccount extends BankAccount implements Loanable{
    SavingsAccount(String a,String n,double b){
        super(a,n,b);
    }
    double calculateInterest(){
        return balance*0.04;
    }
    public void applyForLoan(){
        System.out.println("Loan applied for Savings Account");
    }

    public boolean calculateLoanEligibility(){
        return balance>5000;
    }
}
class CurrentAccount extends BankAccount{
    CurrentAccount(String a,String n,double b){
        super(a,n,b);
    }
    double calculateInterest(){
        return balance*0.02;
    }
}
public class BankingSystem{
    public static void main(String[] args){
        BankAccount acc1=new SavingsAccount("ACC1","Ravi",10000);
        BankAccount acc2=new CurrentAccount("ACC2","Amit",8000);
        acc1.getAccountDetails();
        System.out.println("Interest:"+acc1.calculateInterest());
        acc2.getAccountDetails();
        System.out.println("Interest:"+acc2.calculateInterest());
    }
}
