import java.util.Scanner;

public class Friends{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int amarAge=sc.nextInt();
        int amarHeight=sc.nextInt();
        int akbarAge=sc.nextInt();
        int akbarHeight=sc.nextInt();
        int anthonyAge=sc.nextInt();
        int anthonyHeight=sc.nextInt();

        int minAge=Math.min(amarAge,Math.min(akbarAge,anthonyAge));
        if(minAge==amarAge){
            System.out.println("Amar");
        }
        else if(minAge==akbarAge){
            System.out.println("Akbar");
        }
        else{    
            System.out.println("Anthony");
        }
        int maxHeight=Math.max(amarHeight,Math.max(akbarHeight,anthonyHeight));
        if(maxHeight==amarHeight){
            System.out.println("Amar");
        }
        else if(maxHeight==akbarHeight){
            System.out.println("Akbar");
        }
        else{
            System.out.println("Anthony");
        }
    }
}
