public class BankAccount{
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public void setBalance(double balance){
        this.balance=balance;
    }

    public double getBalance(){
        return balance;
    }

    public static void main(String[]args){
        BankAccount b=new BankAccount();
        b.accountNumber=101;
        b.accountHolder="Aryan";
        b.setBalance(5000);
        System.out.println(b.getBalance());
    }
}
