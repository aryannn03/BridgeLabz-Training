import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=factors(n);
        System.out.println("Sum of factors : "+sumOfFactors(arr));
        System.out.println("Product of factors : "+productOfFactors(arr));        
        System.out.println("Sum of Product of factors : "+sumOfSquareOfFactors(arr));        
    }
    public static int sumOfFactors(int arr[]){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        return sum;
    }    
    public static int productOfFactors(int arr[]){
        int product=1;
        for(int i:arr){
            product*=i;
        }
        return product;
    }    
    public static int sumOfSquareOfFactors(int arr[]){
        int sum=0;
        for(int i:arr){
            sum=sum+(int)Math.pow(i,2);
        }
        return sum;
    }    
    public static int[] factors(int n){
        int count=1;
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                count++;
            }
        }
        int arr[]= new int[count];
        int idx=0;
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                arr[idx++]=i;
            }
        }
        arr[idx]=n;
        return arr;
    }
}
