interface PaymentProcessor{
    void processPayment(double amount);
    default void refund(double amount){
        System.out.println("Refunded "+amount);
    }
}

class PhonePe implements PaymentProcessor{
    public void processPayment(double amount){
        System.out.println("Payment of "+amount+" processed via PhonePe");
    }
}

public class PaymentSystem{
    public static void main(String[] args){
        PaymentProcessor p=new PhonePe();
        p.processPayment(500);
        p.refund(200);
    }
}
