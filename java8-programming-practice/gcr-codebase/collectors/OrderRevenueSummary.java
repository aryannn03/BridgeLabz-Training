import java.util.*;
import java.util.stream.*;

public class OrderRevenueSummary {

    static class Order {
        String customer;
        double amount;

        Order(String customer,double amount){
            this.customer=customer;
            this.amount=amount;
        }

        String getCustomer(){
            return customer;
        }

        double getAmount(){
            return amount;
        }
    }

    public static void main(String[] args){

        List<Order> orders=Arrays.asList(
                new Order("Aryan",1200.50),
                new Order("Rohit",800.00),
                new Order("Aryan",300.75),
                new Order("Neha",1500.00),
                new Order("Rohit",200.25)
        );

        Map<String,Double> revenueByCustomer=
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.summingDouble(Order::getAmount)
                        ));

        revenueByCustomer.forEach((customer,total)->{
            System.out.println(customer+" -> "+total);
        });
    }
}
