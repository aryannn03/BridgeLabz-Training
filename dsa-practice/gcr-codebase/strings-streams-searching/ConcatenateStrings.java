import java.util.Scanner;

public class ConcatenateStrings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String arr[]=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLine();
        }
        String result=concatenateStrings(arr);
        System.out.println(result);
        sc.close();
    }    
    public static String concatenateStrings(String[] arr) {
        StringBuffer sb=new StringBuffer();
        for(String str:arr){
            sb.append(str);
        }
        return sb.toString();
    }
}
