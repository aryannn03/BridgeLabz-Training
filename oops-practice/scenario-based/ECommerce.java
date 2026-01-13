import java.util.*;
class Customer{
    int customer_id;
    String name;
    String address;
    Customer(int customer_id,String name,String address){
        this.customer_id=customer_id;
        this.name=name;
        this.address=address;
    }
}
class Product{
    int model_number;
    String product_name;
    double price;
    Product(int model_number,String product_name,double price){
        this.model_number=model_number;
        this.product_name=product_name;
        this.price=price;
    }
}
class Order{
    int order_id;
    Customer customer;
    Product product;
    int quantity;
    Order(int order_id,Customer customer,Product product,int quantity){
        this.order_id=order_id;
        this.customer=customer;
        this.product=product;
        this.quantity=quantity;
    }
    void displayOrderDetails(){
        System.out.println("Order ID: "+order_id);
        System.out.println("Customer Name: "+customer.name);
        System.out.println("Product Name: "+product.product_name);
        System.out.println("Price: "+product.price);
    }
    void OrderPlacement(){
        System.out.println("Order placed successfully for "+product.product_name);
    }
    void OrderCancellation(){
        System.out.println("Order with ID "+order_id+" has been cancelled.");
    }
}
interface Upi{
    void payViaUpi(String upiId);
}
interface Wallet{
    void payViaWallet(String walletId);
}
interface Card{
    void payViaCard(String card_number);
}
class Payment implements Upi,Wallet,Card{
    public void payViaUpi(String UpiId){
        try{
            if(!UpiId.contains("@")){
                throw new Exception();
            }
            System.out.println("Payment done via UPI");
        }
        catch(Exception e){
            System.out.println("Invalid UPI ID");
            System.out.println("Payment failed");
        }
    }
    public void payViaWallet(String walletId){
        try{
            if(walletId.length()<6){
                throw new Exception();
            }
            System.out.println("Payment done via Wallet");
        }
        catch(Exception e){
            System.out.println("Invalid Wallet ID");
            System.out.println("Payment failed");
            return;
        }
    }
    public void payViaCard(String card_number){
        try{
            String cardNumStr=String.valueOf(card_number);
            if(cardNumStr.length()!=16){
                throw new Exception();
            }
            System.out.println("Payment done via Card");
        }
        catch(Exception e){
            System.out.println("Invalid Card Number");
            System.out.println("Payment failed");
            return;
        }
    }
}
public class ECommerce {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int userId=1;
        while(true){
            System.out.print("Enter 1 to resiter yourself or 0 to exit: ");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==0){
                System.out.println("Thank you for visiting!");
                return;
            }
            else if(choice==1){
                System.out.print("Enter your name: ");
                String name=sc.nextLine();
                System.out.print("Enter your address: ");
                String address=sc.nextLine();
                Customer customer=new Customer(userId,name,address);
                System.out.println("Registered successfully with Customer ID: "+userId);
                userId++;
                List<Product> products=new ArrayList<>();
                products.add(new Product(101,"Laptop",50000));
                products.add(new Product(102,"Smartphone",20000));
                products.add(new Product(103,"Headphones",2000));
                System.out.println("Enter 1 to choose the product from the catalog");
                int prodChoice=sc.nextInt();
                if(prodChoice==1){
                    List<Product> cart=new ArrayList<>();
                    System.out.println("Available Products");
                    for(Product p:products){
                        System.out.println("Model Number: "+p.model_number+" Product Name: "+p.product_name+" Price: "+p.price);
                        System.out.println("Enter 1 to select this product or 0 to skip:");
                        int select=sc.nextInt();
                        if(select==1){
                            cart.add(p);
                        }
                    }
                    if(cart.isEmpty()){
                        System.out.println("No products selected. Exiting.");
                        return;
                    }
                    System.out.println("Enter 1 to place order for selected products:");
                    int orderChoice=sc.nextInt();
                    List<Order> orders=new ArrayList<>();
                    if(orderChoice==1){
                        for(Product p:cart){
                            System.out.println("Enter quantity for product "+p.product_name+":");
                            int qty=sc.nextInt();
                            Order order=new Order(new Random().nextInt(1000,9999),customer,p,qty);
                            order.displayOrderDetails();
                            orders.add(order);
                        }
                        System.out.println("Choose payment method: 1.UPI 2.Wallet 3.Card");
                        int paymentChoice=sc.nextInt();
                        if(paymentChoice==1){
                            System.out.println("Enter UPI ID:");
                            String upiId=sc.next();
                            Upi payment=new Payment();
                            payment.payViaUpi(upiId);
                        }
                        else if(paymentChoice==2){
                            System.out.println("Enter Wallet ID:");
                            String walletId=sc.next();
                            Wallet payment=new Payment();
                            payment.payViaWallet(walletId);
                        }
                        else if(paymentChoice==3){
                            System.out.println("Enter Card Number:");
                            String cardNumber=sc.next();
                            Card payment=new Payment();
                            payment.payViaCard(cardNumber);
                        }
                        else{
                            System.out.println("Invalid payment choice. Exiting.");
                            return;
                        }
                        for(Order o:orders){
                            o.OrderPlacement();
                        }
                        System.out.println("Orders placed Successfully");
                        System.out.println("Enter 1 to cancel any order: ");
                        int cancelChoice=sc.nextInt();
                        if(cancelChoice==1){
                            System.out.print("Enter Order ID to cancel: ");
                            int orderIdToCancel=sc.nextInt();
                            boolean found=false;
                            for(Order o:orders){
                                if(o.order_id==orderIdToCancel){
                                    o.OrderCancellation();
                                    orders.remove(o);
                                    found=true;
                                    break;
                                }
                            }
                            if(!found){
                                System.out.println("Order ID not found.");
                            }
                            else{
                                System.out.println("Order cancelled successfully.");
                            }
                        }
                    }
                    else{
                        System.out.println("Exiting without placing order.");
                        return;
                    }
                }
                else{
                    System.out.println("Invalid choice. Exiting.");
                    return;
                }
            }
            else{
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

        }
    }
}
