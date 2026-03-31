import java.util.*;
class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String msg){
        super(msg);
    }
}
abstract class Account{
    int accountNo;
    String holderName;
    double balance;
    ArrayList<String>transactions=new ArrayList<>();
    Account(int accountNo,String holderName,double balance){
        this.accountNo=accountNo;
        this.holderName=holderName;
        this.balance=balance;
    }
    abstract double calculateInterest();
    synchronized void deposit(double amount){
        balance+=amount;
        transactions.add("Deposited:"+amount);
    }
    synchronized void withdraw(double amount)throws InsufficientBalanceException{
        if(balance<amount)
            throw new InsufficientBalanceException("Insufficient balance");
        balance-=amount;
        transactions.add("Withdrawn:"+amount);
    }
    double getBalance(){
        return balance;
    }
    void showTransactions(){
        for(String t:transactions){
            System.out.println(t);
        }
    }
}
class SavingsAccount extends Account{
    SavingsAccount(int accountNo,String holderName,double balance){
        super(accountNo,holderName,balance);
    }
    double calculateInterest(){
        return balance*0.04;
    }
}
class CurrentAccount extends Account{
    CurrentAccount(int accountNo,String holderName,double balance){
        super(accountNo,holderName,balance);
    }
    double calculateInterest(){
        return balance*0.02;
    }
}
interface BankService{
    void transfer(Account from,Account to,double amount)throws InsufficientBalanceException;
}
class BankServiceImpl implements BankService{
    public synchronized void transfer(Account from,Account to,double amount)throws InsufficientBalanceException{
        from.withdraw(amount);
        to.deposit(amount);
        from.transactions.add("Transferred:"+amount+" to "+to.accountNo);
        to.transactions.add("Received:"+amount+" from "+from.accountNo);
    }
}
class TransactionThread extends Thread{
    Account account;
    double amount;
    boolean isDeposit;
    TransactionThread(Account account,double amount,boolean isDeposit){
        this.account=account;
        this.amount=amount;
        this.isDeposit=isDeposit;
    }
    public void run(){
        try{
            if(isDeposit)
                account.deposit(amount);
            else
                account.withdraw(amount);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
public class BankingSystem{
    static ArrayList<Account>accounts=new ArrayList<>();
    static Account findAccount(int accNo){
        for(Account a:accounts){
            if(a.accountNo==accNo)
                return a;
        }
        return null;
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        BankService service=new BankServiceImpl();
        boolean loop=true;
        while(loop){
            System.out.println("1.Create Account");
            System.out.println("2.Check Balance");
            System.out.println("3.Deposit");
            System.out.println("4.Withdraw");
            System.out.println("5.Transfer");
            System.out.println("6.Transaction History");
            System.out.println("0.Exit");
            int choice=ob.nextInt();
            ob.nextLine();
            if(choice==1){
                System.out.println("Enter account type(savings/current)");
                String type=ob.nextLine();
                System.out.println("Enter account number");
                int accNo=ob.nextInt();
                ob.nextLine();
                System.out.println("Enter holder name");
                String name=ob.nextLine();
                System.out.println("Enter initial balance");
                double bal=ob.nextDouble();
                ob.nextLine();
                if(type.equalsIgnoreCase("savings"))
                    accounts.add(new SavingsAccount(accNo,name,bal));
                else
                    accounts.add(new CurrentAccount(accNo,name,bal));
                System.out.println("Account created successfully");
            }
            else if(choice==2){
                System.out.println("Enter account number");
                int accNo=ob.nextInt();
                Account a=findAccount(accNo);
                if(a!=null)
                    System.out.println("Balance:"+a.getBalance());
                else
                    System.out.println("Account not found");
            }
            else if(choice==3){
                System.out.println("Enter account number");
                int accNo=ob.nextInt();
                System.out.println("Enter amount");
                double amt=ob.nextDouble();
                Account a=findAccount(accNo);
                if(a!=null){
                    new TransactionThread(a,amt,true).start();
                }else{
                    System.out.println("Account not found");
                }
            }
            else if(choice==4){
                System.out.println("Enter account number");
                int accNo=ob.nextInt();
                System.out.println("Enter amount");
                double amt=ob.nextDouble();
                Account a=findAccount(accNo);
                if(a!=null){
                    new TransactionThread(a,amt,false).start();
                }else{
                    System.out.println("Account not found");
                }
            }
            else if(choice==5){
                System.out.println("Enter from account number");
                int from=ob.nextInt();
                System.out.println("Enter to account number");
                int to=ob.nextInt();
                System.out.println("Enter amount");
                double amt=ob.nextDouble();
                try{
                    service.transfer(findAccount(from),findAccount(to),amt);
                    System.out.println("Transfer successful");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            else if(choice==6){
                System.out.println("Enter account number");
                int accNo=ob.nextInt();
                Account a=findAccount(accNo);
                if(a!=null)
                    a.showTransactions();
                else
                    System.out.println("Account not found");
            }
            else{
                loop=false;
            }
        }
    }
}