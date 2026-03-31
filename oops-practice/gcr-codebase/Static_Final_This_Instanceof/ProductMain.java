class Product{
    private static double discount=10;

    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    Product(String productID,String productName,double price,int quantity){
        this.productID=productID;
        this.productName=productName;
        this.price=price;
        this.quantity=quantity;
    }

    static void updateDiscount(double d){
        discount=d;
    }

    void display(){
        if(this instanceof Product){
            System.out.println("Product ID: "+productID);
            System.out.println("Product Name: "+productName);
            System.out.println("Price: $"+price);
            System.out.println("Quantity: "+quantity);
            System.out.println("Discount: "+discount+"%");
            System.out.println("Price after Discount: $"+(price-(price*discount/100)));
        }
    }
}

public class ProductMain{
    public static void main(String[]args){
        Product p1=new Product("P001","Laptop",1200,5);
        Product p2=new Product("P002","Smartphone",800,10);

        p1.display();
        p2.display();
    }
}
