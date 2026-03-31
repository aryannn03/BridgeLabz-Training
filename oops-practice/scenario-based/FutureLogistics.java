import java.util.Scanner;

abstract class GoodsTransport{
    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    public GoodsTransport(String transportId,String transportDate,int transportRating){
        this.transportId=transportId;
        this.transportDate=transportDate;
        this.transportRating=transportRating;
    }

    public String getTransportId(){
        return transportId;
    }
    public String getTransportDate(){
        return transportDate;
    }
    public int getTransportRating(){
        return transportRating;
    }

    public abstract String vehicleSelection();
    public abstract float calculateTotalCharge();
}

class BrickTransport extends GoodsTransport{
    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId,String transportDate,int transportRating,
                          float brickSize,int brickQuantity,float brickPrice){
        super(transportId,transportDate,transportRating);
        this.brickSize=brickSize;
        this.brickQuantity=brickQuantity;
        this.brickPrice=brickPrice;
    }

    public String vehicleSelection(){
        if(brickQuantity<300){
            return "Truck";
        }else if(brickQuantity<=500){
            return "Lorry";
        }
        return "MonsterLorry";
    }

    public float calculateTotalCharge(){
        float price=brickQuantity*brickPrice;
        float tax=price*0.30f;

        float discount=0;
        if(transportRating==5){
            discount=price*0.20f;
        }else if(transportRating==3||transportRating==4){
            discount=price*0.10f;
        }

        float vehicleCost;
        String vehicle=vehicleSelection();

        if(vehicle.equals("Truck")){
            vehicleCost=1000;
        }else if(vehicle.equals("Lorry")){
            vehicleCost=1700;
        }else{
            vehicleCost=3000;
        }

        return price+tax+vehicleCost-discount;
    }
}

class TimberTransport extends GoodsTransport{
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId,String transportDate,int transportRating,
                           float timberLength,float timberRadius,
                           String timberType,float timberPrice){
        super(transportId,transportDate,transportRating);
        this.timberLength=timberLength;
        this.timberRadius=timberRadius;
        this.timberType=timberType;
        this.timberPrice=timberPrice;
    }

    public String vehicleSelection(){
        float area=2*3.147f*timberRadius*timberLength;
        if(area<250){
            return "Truck";
        }else if(area<=400){
            return "Lorry";
        }
        return "MonsterLorry";
    }

    public float calculateTotalCharge(){
        float volume=3.147f*timberRadius*timberRadius*timberLength;

        float rate;
        if(timberType.equalsIgnoreCase("Premium")){
            rate=0.25f;
        }else{
            rate=0.15f;
        }

        float price=volume*timberPrice*rate;
        float tax=price*0.30f;

        float discount=0;
        if(transportRating==5){
            discount=price*0.20f;
        }else if(transportRating==3||transportRating==4){
            discount=price*0.10f;
        }

        float vehicleCost;
        String vehicle=vehicleSelection();

        if(vehicle.equals("Truck")){
            vehicleCost=1000;
        }else if(vehicle.equals("Lorry")){
            vehicleCost=1700;
        }else{
            vehicleCost=3000;
        }

        return price+tax+vehicleCost-discount;
    }
}

class Utility{
    public boolean validateTransportId(String transportId){
        return transportId.matches("^RTS\\d{3}[A-Z]$");
    }

    public GoodsTransport parseDetails(String input){
        String[]d=input.split(":");

        String id=d[0];
        String date=d[1];
        int rating=Integer.parseInt(d[2]);
        String type=d[3];

        if(type.equalsIgnoreCase("BrickTransport")){
            return new BrickTransport(
                id,date,rating,
                Float.parseFloat(d[4]),
                Integer.parseInt(d[5]),
                Float.parseFloat(d[6])
            );
        }else{
            return new TimberTransport(
                id,date,rating,
                Float.parseFloat(d[4]),
                Float.parseFloat(d[5]),
                d[6],
                Float.parseFloat(d[7])
            );
        }
    }

    public String findObjectType(GoodsTransport g){
        if(g instanceof BrickTransport){
            return "BrickTransport";
        }
        return "TimberTransport";
    }
}

public class FutureLogistics{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        Utility u=new Utility();

        System.out.println("Enter the Goods Transport details");
        String input=sc.nextLine();

        String transportId=input.split(":")[0];

        if(!u.validateTransportId(transportId)){
            System.out.println("Transport id "+transportId+" is invalid");
            System.out.println("Please provide a valid record");
            return;
        }

        GoodsTransport g=u.parseDetails(input);

        System.out.println("Transport Id: "+g.getTransportId());
        System.out.println("Transport Date: "+g.getTransportDate());
        System.out.println("Transport Rating: "+g.getTransportRating());
        System.out.println("Transport Type: "+u.findObjectType(g));
        System.out.println("Vehicle for transport: "+g.vehicleSelection());
        System.out.println("Total Charge: "+g.calculateTotalCharge());
    }
}
