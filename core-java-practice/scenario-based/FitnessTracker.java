import java.util.Scanner;
public class FitnessTracker{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int[]pushUps=new int[7];
        for(int day=0;day<7;day++){
            pushUps[day]=sc.nextInt();
        }
        int total=0;
        int activeDays=0;
        for(int count:pushUps){
            if(count==0){
                continue;
            }
            total+=count;
            activeDays++;
        }
        double average=(double)total/activeDays;
        System.out.println("Total PushUps="+total);
        System.out.println("Average PushUps="+average);
    }
}
