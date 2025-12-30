import java.util.*;
public class LineComparison {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Line Comparison Computation");
        double line1Length = length(sc, 1);
        double line2Length = length(sc, 2);
        compareLines(line1Length, line2Length);
        compareTo(line1Length,line2Length);
    }
    
    public static double length(Scanner sc, int lineNumber) {
        System.out.println("Enter coordinates for Line " + lineNumber);
        System.out.print("Enter value of x1: ");
        int x1=sc.nextInt();
        System.out.print("Enter value of y1: ");
        int y1=sc.nextInt();
        System.out.print("Enter value of x2: ");
        int x2=sc.nextInt();
        System.out.print("Enter value of y2: ");
        int y2=sc.nextInt();
        double lengthOfLine =Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("Length of Line " + lineNumber + ": " + lengthOfLine);
        return lengthOfLine;
    }
    
    public static void compareLines(double length1, double length2) {
        Double line1=length1;
        Double line2=length2;
        System.out.println("Comparing both lines...");
        if(line1.equals(line2)){
            System.out.println("Both lines are equal");
        } 
        else{
            System.out.println("Both lines are NOT equal");
        }
    }
    
    public static void compareTo(double length1,double length2){
        Double line1=length1;
        Double line2=length2;
        int result=line1.compareTo(line2);
        if(result==0) {
            System.out.println("Both lines are equal");
        }
        else if(result>0) {
            System.out.println("Line 1 is greater than Line 2");
        }
        else{
            System.out.println("Line 1 is less than Line 2");
        }
    }
}
