interface Taxable{
    double calculateTax();
}
abstract class Product{
    protected double price;
    Product(double price){
        this.price=price;
    }
    abstract double calculateDiscount();
    double finalPrice(){
        return price+calculateTax()-calculateDiscount();
    }
    double calculateTax(){
        return 0;
    }
}
class Electronics extends Product implements Taxable{
    Electronics(double price){
        super(price);
    }
    double calculateDiscount(){
        return price*0.1;
    }
    public double calculateTax(){
        return price*0.18;
    }
}
public class Ecommerce{
    public static void main(String[] args){
        Product p=new Electronics(1000);
        System.out.println("Final Price:"+p.finalPrice());
    }
}
