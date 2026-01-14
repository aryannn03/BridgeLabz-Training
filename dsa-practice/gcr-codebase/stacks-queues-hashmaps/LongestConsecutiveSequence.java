import java.util.*;

public class LongestConsecutiveSequence{
    public static void main(String[] args){
        int[] arr={100,4,200,1,3,2};
        System.out.print(longestConsecutive(arr));
    }
    public static int longestConsecutive(int[] arr){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int longest=0;
        for(int i=0;i<arr.length;i++){
            if(!set.contains(arr[i]-1)){
                int current=arr[i];
                int count=1;
                while(set.contains(current+1)){
                    current++;
                    count++;
                }
                if(count>longest){
                    longest=count;
                }
            }
        }
        return longest;
    }
}
