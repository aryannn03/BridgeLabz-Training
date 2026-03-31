import java.util.Scanner;

public class NumberGuessingGame{
    public static int generateGuess(int low,int high){
        return low+(int)(Math.random()*(high-low+1));
    }
    public static char getFeedback(Scanner sc){
        return sc.next().charAt(0);
    }
    public static int[]updateRange(int guess,char feedback,int low,int high){
        if(feedback=='h'){
            high=guess-1;
        }else if(feedback=='l'){
            low=guess+1;
        }
        return new int[]{low,high};
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int low=1;
        int high=100;
        while(true){
            int guess=generateGuess(low,high);
            System.out.println("Computer Guess: "+guess);
            System.out.println("Enter feedback (h=high,l=low,c=correct)");
            char feedback=getFeedback(sc);
            if(feedback=='c'){
                System.out.println("Computer guessed correctly!");
                break;
            }
            int[]range=updateRange(guess,feedback,low,high);
            low=range[0];
            high=range[1];
        }
    }
}
