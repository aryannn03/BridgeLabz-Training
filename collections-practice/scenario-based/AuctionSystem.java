import java.util.*;

class InvalidBidException extends Exception{
    public InvalidBidException(String msg){
        super(msg);
    }
}

class User{
    private String name;

    public User(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return name;
    }
}

class Bid{
    private User user;
    private double amount;

    public Bid(User user,double amount){
        this.user=user;
        this.amount=amount;
    }

    public User getUser(){
        return user;
    }

    public double getAmount(){
        return amount;
    }
}

class AuctionItem{
    private String itemName;
    private TreeMap<User,Double> bids=new TreeMap<>(Comparator.comparing(User::getName));

    public AuctionItem(String itemName){
        this.itemName=itemName;
    }

    public void placeBid(Bid bid)throws InvalidBidException{
        double highest=getHighestBidAmount();
        if(bid.getAmount()<=highest){
            throw new InvalidBidException("Bid must be higher than current highest bid");
        }
        bids.put(bid.getUser(),bid.getAmount());
    }

    public double getHighestBidAmount(){
        double max=0;
        for(double amt:bids.values()){
            if(amt>max){
                max=amt;
            }
        }
        return max;
    }

    public void showHighestBid(){
        System.out.println("Highest Bid: "+getHighestBidAmount());
    }
}

public class AuctionSystem{
    public static void main(String[] args){
        try{
            AuctionItem item=new AuctionItem("Laptop");

            User u1=new User("Amit");
            User u2=new User("Neha");

            item.placeBid(new Bid(u1,1000));
            item.placeBid(new Bid(u2,1500));

            item.showHighestBid();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}