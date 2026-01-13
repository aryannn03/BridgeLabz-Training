import java.util.*;

class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String msg){
        super(msg);
    }
}

interface TransferService{
    void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException;
}

class WalletToWalletTransfer implements TransferService{
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException{
        if(from.balance < amount){
            throw new InsufficientBalanceException("Insufficient balance in sender wallet");
        }
        from.balance -= amount;
        to.balance += amount;
        from.addTransaction("Transferred " + amount + " to Wallet " + to.walletId);
        to.addTransaction("Received " + amount + " from Wallet " + from.walletId);
    }
}

class BankTransfer implements TransferService{
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException{
        if(from.balance < amount){
            throw new InsufficientBalanceException("Insufficient balance for bank transfer");
        }
        double fee = 10;
        from.balance -= (amount + fee);
        to.balance += amount;
        from.addTransaction("Bank Transfer " + amount + " to Wallet " + to.walletId + " (Fee " + fee + ")");
        to.addTransaction("Received " + amount + " via Bank Transfer");
    }
}

class User{
    int userId;
    String name;

    User(int userId,String name){
        this.userId=userId;
        this.name=name;
    }
}

class Transaction{
    int transactionId;
    String description;

    Transaction(int transactionId,String description){
        this.transactionId=transactionId;
        this.description=description;
    }
}

class Wallet{
    int walletId;
    User user;
    double balance;
    List<Transaction> transactions;
    static int txCounter=1;

    Wallet(int walletId,User user){
        this.walletId=walletId;
        this.user=user;
        this.balance=0;
        this.transactions=new ArrayList<>();
    }

    void addMoney(double amount){
        balance+=amount;
        addTransaction("Added money: " + amount);
    }

    void withdrawMoney(double amount) throws InsufficientBalanceException{
        if(balance < amount){
            throw new InsufficientBalanceException("Insufficient balance to withdraw");
        }
        balance-=amount;
        addTransaction("Withdrawn money: " + amount);
    }

    void addTransaction(String desc){
        transactions.add(new Transaction(txCounter++,desc));
    }

    void showTransactions(){
        if(transactions.isEmpty()){
            System.out.println("No transactions");
            return;
        }
        for(Transaction t:transactions){
            System.out.println(t.transactionId+" : "+t.description);
        }
    }
}

public class DigitalWalletSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        Map<Integer,Wallet> wallets=new HashMap<>();

        while(true){
            System.out.println("1.Create Wallet");
            System.out.println("2.Add Money");
            System.out.println("3.Withdraw Money");
            System.out.println("4.Transfer Funds");
            System.out.println("5.View Transactions");
            System.out.println("0.Exit");
            System.out.print("Choice: ");
            int ch=sc.nextInt();

            if(ch==0) break;

            try{
                switch(ch){
                    case 1:
                        System.out.print("User ID: ");
                        int uid=sc.nextInt();
                        sc.nextLine();
                        System.out.print("User Name: ");
                        String uname=sc.nextLine();
                        System.out.print("Wallet ID: ");
                        int wid=sc.nextInt();
                        wallets.put(wid,new Wallet(wid,new User(uid,uname)));
                        System.out.println("Wallet Created");
                        break;

                    case 2:
                        System.out.print("Wallet ID: ");
                        wid=sc.nextInt();
                        System.out.print("Amount: ");
                        double amt=sc.nextDouble();
                        wallets.get(wid).addMoney(amt);
                        System.out.println("Money Added");
                        break;

                    case 3:
                        System.out.print("Wallet ID: ");
                        wid=sc.nextInt();
                        System.out.print("Amount: ");
                        amt=sc.nextDouble();
                        wallets.get(wid).withdrawMoney(amt);
                        System.out.println("Money Withdrawn");
                        break;

                    case 4:
                        System.out.print("From Wallet ID: ");
                        int from=sc.nextInt();
                        System.out.print("To Wallet ID: ");
                        int to=sc.nextInt();
                        System.out.print("Amount: ");
                        amt=sc.nextDouble();
                        System.out.print("1.Wallet Transfer  2.Bank Transfer: ");
                        int type=sc.nextInt();
                        TransferService ts = (type==1)
                                ? new WalletToWalletTransfer()
                                : new BankTransfer();
                        ts.transfer(wallets.get(from),wallets.get(to),amt);
                        System.out.println("Transfer Successful");
                        break;

                    case 5:
                        System.out.print("Wallet ID: ");
                        wid=sc.nextInt();
                        wallets.get(wid).showTransactions();
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
            }catch(InsufficientBalanceException e){
                System.out.println(e.getMessage());
            }catch(Exception e){
                System.out.println("Invalid Operation");
            }
        }
        sc.close();
    }
}
