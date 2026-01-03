
class Order {
    String oid;
    String odate;

    Order(String i,String d){
        oid=i;
        odate=d;
    }
}

class ShippedOrder extends Order {
    String track;

    ShippedOrder(String i,String d,String t){
        super(i,d);
        track=t;
    }
}

class DeliveredOrder extends ShippedOrder {
    String delDate;

    DeliveredOrder(String i,String d,String t,String dd){
        super(i,d,t);
        delDate=dd;
    }

    String getOrderStatus(){
        return "Delivered on "+delDate;
    }
}

public class Main {
    public static void main(String[] args){
        DeliveredOrder o=new DeliveredOrder("O101","01-Jan","TR123","05-Jan");
        System.out.println(o.getOrderStatus());
    }
}
