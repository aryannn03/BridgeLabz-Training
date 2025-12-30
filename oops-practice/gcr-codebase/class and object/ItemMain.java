class Item{
    private String itemCode;
    private String itemName;
    private double price;

    Item(String itemCode,String itemName,double price){
        this.itemCode=itemCode;
        this.itemName=itemName;
        this.price=price;
    }

    void display(){
        System.out.println("itemCode : "+itemCode);
        System.out.println("itemPrice : "+price);
        System.out.println("itemName : "+itemName);
        System.out.println("----------------------------");
    }
}

public class ItemMain{
    public static void main(String[]args){
        Item i1=new Item("01AA","Water bottle",500.0);
        Item i2=new Item("01BB","Rice",700.0);
        Item i3=new Item("02AA","blackboard",400.0);
        i1.display();
        i2.display();
        i3.display();
    }
}
