class BankAccount{
    private String holder;
    private String acc;
    private double balance;

    BankAccount(String holder,String acc,double balance){
        this.holder=holder;
        this.acc=acc;
        this.balance=balance;
    }

    void deposit(double amt){
        balance+=amt;
        System.out.println("Deposited: "+amt);
    }

    void withdraw(double amt){
        if(balance>=amt){
            balance-=amt;
            System.out.println("Withdraw amount is : "+amt);
        }else{
            System.out.println("Insufficient balance");
        }
    }

    void display(){
        System.out.println("Current balance: "+balance);
    }
}

public class BankAccountMain{
    public static void main(String[]args){
        BankAccount b=new BankAccount("State of Chennai","SBI001",700);
        b.display();
        b.deposit(200);
        b.display();
        b.withdraw(100);
        b.display();
        b.withdraw(1000);
    }
}
