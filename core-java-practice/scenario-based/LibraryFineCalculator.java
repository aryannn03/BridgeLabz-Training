import java.util.Scanner;
public class LibraryFineCalculator{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        for(int book=1;book<=5;book++){
            int dueDate=sc.nextInt();
            int returnDate=sc.nextInt();
            if(returnDate>dueDate){
                int fine=(returnDate-dueDate)*5;
                System.out.println("Book "+book+" Fine="+fine);
            }
            else{
                System.out.println("Book "+book+" No Fine");
            }
        }
    }
}
