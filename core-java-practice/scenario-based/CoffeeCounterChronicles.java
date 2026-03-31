import java.util.*;

public class CoffeeCounterChronicles {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        while(true){
            String coffeeType=sc.next();
            if(coffeeType.equals("exit"))
                break;

            int quantity=sc.nextInt();
            double price=0;

            switch(coffeeType){
                case "espresso":
                    price=150;
                    break;
                case "latte":
                    price=200;
                    break;
                case "cappuccino":
                    price=180;
                    break;
                default:
                    System.out.println("Invalid Coffee Type");
                    continue;
            }
            double bill=price*quantity;
            double gst=bill*0.05;
            double total=bill+gst;
            System.out.println("Bill : "+bill);
            System.out.println("GST : "+gst);
            System.out.println("Total : "+total);
        }
    }
}