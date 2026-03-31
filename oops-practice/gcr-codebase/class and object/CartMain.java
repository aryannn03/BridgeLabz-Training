class CartItem{
    private String name;
    private double price;
    private int qty;

    CartItem(String name,double price,int qty){
        this.name=name;
        this.price=price;
        this.qty=qty;
    }

    void add(int q){
        qty+=q;
        System.out.println("Added "+q+" of "+name+" to the cart.");
    }

    void remove(int q){
        qty-=q;
        System.out.println("Removed "+q+" of "+name+" from the cart.");
    }

    void display(){
        System.out.println("Item: "+name+", Price: $"+price+", Quantity: "+qty);
        System.out.println("Total cost: $"+(price*qty));
    }
}

public class CartMain{
    public static void main(String[]args){
        CartItem c=new CartItem("Laptop",999.99,1);
        c.display();
        c.add(2);
        c.remove(1);
        c.display();
    }
}
