class BankAccount {
    int accNo;
    double bal;

    BankAccount(int a,double b){
        accNo=a;
        bal=b;
    }
}

class SavingsAccount extends BankAccount {
    double rate;

    SavingsAccount(int a,double b,double r){
        super(a,b);
        rate=r;
    }

    void displayAccountType(){
        System.out.println("Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    int limit;

    CheckingAccount(int a,double b,int l){
        super(a,b);
        limit=l;
    }

    void displayAccountType(){
        System.out.println("Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    int years;

    FixedDepositAccount(int a,double b,int y){
        super(a,b);
        years=y;
    }

    void displayAccountType(){
        System.out.println("Fixed Deposit Account");
    }
}
