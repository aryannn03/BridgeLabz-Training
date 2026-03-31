public class CarRental{
    String customerName;
    String carModel;
    int rentalDays;
    int ratePerDay=1000;

    public CarRental(String customerName,String carModel,int rentalDays){
        this.customerName=customerName;
        this.carModel=carModel;
        this.rentalDays=rentalDays;
    }

    int totalCost(){
        return rentalDays*ratePerDay;
    }

    public static void main(String[]args){
        CarRental c=new CarRental("Aryan","Swift",5);
        System.out.println(c.totalCost());
    }
}
