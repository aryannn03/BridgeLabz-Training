import java.util.*;

public class ZeroSumSubarrays {
    public static void main(String[] args){
        int[] arr={3,4,-7,3,1,3,1,-4};
        findSubarrays(arr);
    }
    public static void findSubarrays(int[] arr){
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int sum=0;
        map.put(0,new ArrayList<>());
        map.get(0).add(-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                ArrayList<Integer> list=map.get(sum);
                for(int start:list){
                    System.out.print("["+ (start+1) +","+ i +"]");
                }
            }
            map.putIfAbsent(sum,new ArrayList<>());
            map.get(sum).add(i);
        }
    }
}
