public class BankAccount{
    private double balance;

    public void deposit(double amount){
        balance+=amount;
    }

    public void withdraw(double amount){
        if(amount>balance){
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance-=amount;
    }

    public double getBalance(){
        return balance;
    }

    public static void main(String[]args){
        BankAccount b=new BankAccount();
        b.deposit(1000);
        b.withdraw(400);
        System.out.println(b.getBalance());
    }
}
