import java.util.*;
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int arr[]= new int[2];
        int mis=0;
        int v=1;
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                arr[0]=nums[i];
                break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=v){
                mis=v;
                arr[1]=mis;
                return arr;
            }
            else if(i!= nums.length-1 && nums[i]!=nums[i+1] && nums[i]==v){
                v++;
            }
        }
        arr[1]=nums[nums.length-1]+1;
        return arr;
    }
}