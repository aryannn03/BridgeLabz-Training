class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer dp[]= new Integer [amount+1];
        int ans=minimum(coins, amount,0,dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public int minimum(int arr[],int amount,int in,Integer dp[]){
        if(amount==0){
            return 0;
        }
        if(dp[amount]!=null){
            return dp[amount];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=in;i<arr.length;i++){
            if(amount-arr[i]>=0){
                int ret=minimum(arr, amount-arr[i],in,dp);
                if(ret!=Integer.MAX_VALUE){
                    ans=Math.min(ans, 1+ret);
                }
            }
        }
        return dp[amount]=ans;
    }
}