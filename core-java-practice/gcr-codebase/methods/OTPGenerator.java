public class OTPGenerator{
    public static int generateOTP(){
        return 100000+(int)(Math.random()*900000);
    }
    public static boolean isUnique(int[] otp){
        for(int i=0;i<otp.length;i++){
            for(int j=i+1;j<otp.length;j++){
                if(otp[i]==otp[j])
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] otp=new int[10];

        for(int i=0;i<10;i++){
            otp[i]=generateOTP();
            System.out.println(otp[i]);
        }

        System.out.println(isUnique(otp));
    }
}
