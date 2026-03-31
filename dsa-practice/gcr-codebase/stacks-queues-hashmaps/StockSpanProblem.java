import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] price={100,80,60,70,60,75,85};
        int[] span=calculateSpan(price);
        for(int i=0;i<span.length;i++){
            System.out.print(span[i]);
        }
    }
    public static int[] calculateSpan(int[] price){
        int n=price.length;
        int[] span=new int[n];
        Stack<Integer> stack=new Stack<>();
        span[0]=1;
        stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty()&&price[i]>=price[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                span[i]=i+1;
            }else{
                span[i]=i-stack.peek();
            }
            stack.push(i);
        }
        return span;
    }
}
