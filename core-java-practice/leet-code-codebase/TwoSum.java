public class TwoSum {
    public int [] twoSum(int nums[],int target){
        int[] f=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){    
                    f[0]=i;
                    f[1]=j;
                    return f;
                }
            }
        }
    return f;
    }
}