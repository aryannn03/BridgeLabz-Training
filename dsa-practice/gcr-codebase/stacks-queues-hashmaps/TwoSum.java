import java.util.HashMap;

public class TwoSum{
    public static void main(String[] args){
        int[] arr={2,7,11,15};
        int target=9;
        int[] res=twoSum(arr,target);
        System.out.print(res[0]);
        System.out.print(res[1]);
    }
    public static int[] twoSum(int[] arr,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int req=target-arr[i];
            if(map.containsKey(req)){
                return new int[]{map.get(req),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
}
