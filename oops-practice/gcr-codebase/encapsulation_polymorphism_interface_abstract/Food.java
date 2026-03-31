interface Discountable{
    double applyDiscount();
    String getDiscountDetails();
}
abstract class FoodItem{
    protected String itemName;
    protected double price;
    protected int quantity;
    FoodItem(String n,double p,int q){
        itemName=n;
        price=p;
        quantity=q;
    }
    abstract double calculateTotalPrice();
    void getItemDetails(){
        System.out.println(itemName+" "+price+" "+quantity);
    }
}
class VegItem extends FoodItem implements Discountable{
    VegItem(String n,double p,int q){
        super(n,p,q);
    }
    double calculateTotalPrice(){
        return price*quantity;
    }
    public double applyDiscount(){
        return calculateTotalPrice()*0.1;
    }
    public String getDiscountDetails(){
        return "10% Veg Discount";
    }
}
class NonVegItem extends FoodItem{
    NonVegItem(String n,double p,int q){
        super(n,p,q);
    }
    double calculateTotalPrice(){
        return(price*quantity)+50;
    }
}
public class Food{
    public static void main(String[] args){
        FoodItem f1=new VegItem("Paneer",200,2);
        FoodItem f2=new NonVegItem("Chicken",300,1);
        System.out.println("Veg Total:"+f1.calculateTotalPrice());
        System.out.println("NonVeg Total:"+f2.calculateTotalPrice());
    }
}
