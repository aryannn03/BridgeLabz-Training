import java.util.Scanner;
public class FriendsStats{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String[]names={"Amar","Akbar","Anthony"};
        int[]ages=new int[3];
        double[]heights=new double[3];
        for(int i=0;i<3;i++){
            ages[i]=sc.nextInt();
            heights[i]=sc.nextDouble();
        }
        int youngestIndex=0;
        int tallestIndex=0;
        for(int i=1;i<3;i++){
            if(ages[i]<ages[youngestIndex]){
                youngestIndex=i;
            }
            if(heights[i]>heights[tallestIndex]){
                tallestIndex=i;
            }
        }
        System.out.println("Youngest is "+names[youngestIndex]);
        System.out.println("Tallest is "+names[tallestIndex]);
    }
}
