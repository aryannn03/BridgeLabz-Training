import java.util.Scanner;

public class DigitalWatch{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int startHour=sc.nextInt();
        int startMinute=sc.nextInt();

        for(int hour=startHour;hour<24;hour++){
            for(int minute=(hour==startHour?startMinute:0);minute<60;minute++){
                if(hour==13&&minute==0){
                    System.out.println("Power Cut");
                    return;
                }
                System.out.printf("%02d:%02d\n",hour,minute);
            }
        }
    }
}
