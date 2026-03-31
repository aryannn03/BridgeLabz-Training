import java.util.*;
public class StringBuilderVsStringBuffer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=1000000;
        System.out.println("Enter the String");
        String str=sc.nextLine();
        builder(str,n);
        buffer(str,n);
        sc.close();
    }
    public static void builder(String str,int n){
        StringBuilder sb=new StringBuilder();
        double start=System.nanoTime();
        for(int i=0;i<n;i++){
            sb.append(str);
        }
        double end=System.nanoTime();
        double timeTaken=end-start;
        System.out.println("Time taken by StringBuilder: "+timeTaken+" nanoseconds");
    }
    public static void buffer(String str,int n){
        StringBuffer sb=new StringBuffer();
        double start=System.nanoTime();
        for(int i=0;i<n;i++){
            sb.append(str);
        }
        double end=System.nanoTime();
        double timeTaken=end-start;
        System.out.println("Time taken by StringBuffer: "+timeTaken+" nanoseconds");
    }
}