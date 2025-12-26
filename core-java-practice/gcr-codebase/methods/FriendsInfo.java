import java.util.Scanner;

public class FriendsInfo{
    public static int youngest(int[] age){
        int min=age[0];
        for(int i:age){
            if(i<min){
                min=i;
            }
        }
        return min;
    }
    public static int tallest(int[] height){
        int max=height[0];
        for(int i:height)if(i>max)max=i;
        return max;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] age=new int[3];
        int[] height=new int[3];
        for(int i=0;i<3;i++){
            age[i]=sc.nextInt();
            height[i]=sc.nextInt();
        }
        System.out.println(youngest(age));
        System.out.println(tallest(height));
    }
}
