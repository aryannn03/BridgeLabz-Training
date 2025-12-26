import java.util.Scanner;
public class BusRouteTracker{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int totalDistance=0;
        while(true){
            int stopDistance=sc.nextInt();
            totalDistance+=stopDistance;
            System.out.println("Total Distance="+totalDistance);
            System.out.println("Press 1 to exit or 2 to continue");
            int choice=sc.nextInt();
            if(choice==1){
                break;
            }
        }
        System.out.println("Journey Ended");
        System.out.println("Final Distance="+totalDistance);
    }
}
