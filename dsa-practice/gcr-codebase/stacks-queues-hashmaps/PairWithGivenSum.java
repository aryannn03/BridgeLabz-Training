import java.util.*;

public class PairWithGivenSum{
    public static void main(String[] args){
        int[] arr={8,7,2,5,3,1};
        int target=10;
        if(hasPairWithSum(arr,target)){
            System.out.print("Pair exists");
        }else{
            System.out.print("Pair does not exist");
        }
    }
    public static boolean hasPairWithSum(int[] arr,int target){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int req=target-arr[i];
            if(set.contains(req)){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
