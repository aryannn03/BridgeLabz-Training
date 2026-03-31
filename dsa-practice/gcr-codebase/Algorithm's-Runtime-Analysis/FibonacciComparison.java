public class FibonacciComparison{
	public static void main(String[] args){
		int n1=30;
		int n2=50;

		long start,end;

		start=System.currentTimeMillis();
		fibonacciRecursive(n1);
		end=System.currentTimeMillis();
		System.out.println("Recursive Fibonacci("+n1+") Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		fibonacciIterative(n1);
		end=System.currentTimeMillis();
		System.out.println("Iterative Fibonacci("+n1+") Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		fibonacciIterative(n2);
		end=System.currentTimeMillis();
		System.out.println("Iterative Fibonacci("+n2+") Time: "+(end-start)+" ms");
	}

	static int fibonacciRecursive(int n){
		if(n<=1)return n;
		return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
	}

	static int fibonacciIterative(int n){
		if(n<=1)return n;
		int a=0,b=1,sum=0;
		for(int i=2;i<=n;i++){
			sum=a+b;
			a=b;
			b=sum;
		}
		return b;
	}
}
