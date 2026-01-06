public class HappyNumber {
    public boolean isHappy(long n) {
        long sum=0;
        while(true){
            long r = n%10;
            sum=sum+(r*r);
            n/=10;
            if(n==0){             
                if(sum<7){
                    break;
                }
                n=sum;               
                sum=0;               
            }
        }
        if(sum==1){
        return true;
        }
        else{
        return false;
     }
    }
}
