import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args){
        int[] arr={1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] res=maxSlidingWindow(arr,k);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]);
        }
    }
    public static int[] maxSlidingWindow(int[] arr,int k){
        int n=arr.length;
        if(n==0||k==0){
            return new int[0];
        }
        int[] result=new int[n-k+1];
        Deque<Integer> dq=new LinkedList<>();
        int idx=0;
        for(int i=0;i<n;i++){
            while(!dq.isEmpty()&&dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&arr[dq.peekLast()]<=arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                result[idx++]=arr[dq.peekFirst()];
            }
        }
        return result;
    }
}
