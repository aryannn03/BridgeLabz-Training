import java.util.*;

class NoAgentAvailableException extends Exception{
    public NoAgentAvailableException(String msg){
        super(msg);
    }
}

class Order{
    private int id;
    private String location;

    public Order(int id,String location){
        this.id=id;
        this.location=location;
    }

    public int getId(){
        return id;
    }

    public String getLocation(){
        return location;
    }

    public String toString(){
        return "Order:"+id+" Location:"+location;
    }
}

class Agent{
    private String name;
    private boolean available=true;

    public Agent(String name){
        this.name=name;
    }

    public boolean isAvailable(){
        return available;
    }

    public void assign(){
        available=false;
    }

    public void free(){
        available=true;
    }

    public String getName(){
        return name;
    }
}

class DeliveryService{
    private Queue<Order> orderQueue=new LinkedList<>();
    private List<Agent> agents=new ArrayList<>();
    private Map<Order,Agent> activeDeliveries=new HashMap<>();

    public void addAgent(Agent agent){
        agents.add(agent);
    }

    public void placeOrder(Order order){
        orderQueue.add(order);
    }

    public void assignOrder()throws NoAgentAvailableException{
        if(orderQueue.isEmpty())return;

        Order order=orderQueue.peek();
        Agent selected=null;

        for(Agent a:agents){
            if(a.isAvailable()){
                selected=a;
                break;
            }
        }

        if(selected==null){
            throw new NoAgentAvailableException("No Agent Available");
        }

        orderQueue.poll();
        selected.assign();
        activeDeliveries.put(order,selected);
        System.out.println("Assigned "+order+" to "+selected.getName());
    }

    public void cancelOrder(Order order){
        orderQueue.remove(order);
        System.out.println("Order Cancelled:"+order);
    }

    public void viewActiveDeliveries(){
        for(Order o:activeDeliveries.keySet()){
            System.out.println(o+" -> "+activeDeliveries.get(o).getName());
        }
    }
}

public class FoodDeliverySystem{
    public static void main(String[] args){
        try{
            DeliveryService service=new DeliveryService();

            service.addAgent(new Agent("Ravi"));
            service.addAgent(new Agent("Amit"));

            service.placeOrder(new Order(1,"Sector 10"));
            service.placeOrder(new Order(2,"Sector 20"));

            service.assignOrder();
            service.assignOrder();

            service.viewActiveDeliveries();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}