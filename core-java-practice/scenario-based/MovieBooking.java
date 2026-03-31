import java.util.Scanner;
public class MovieBooking{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(true){
            int movieType=sc.nextInt();
            if(movieType==0){
                break;
            }
            int seatType=sc.nextInt();
            boolean snacks=sc.nextBoolean();
            int price=0;
            switch(movieType){
                case 1:price=200;break;
                case 2:price=250;break;
                case 3:price=300;break;
            }
            if(seatType==1){
                price+=100;
            }else{
                price+=50;
            }
            if(snacks){
                price+=80;
            }
            System.out.println("Total Bill="+price);
        }
    }
}
