public class RandomStats{
    public static int[] generate4DigitRandomArray(int size){
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=1000+(int)(Math.random()*9000);
        }
        return arr;
    }
    public static double[] findAverageMinMax(int[] n){
        int min=n[0];
        int max=n[0];
        int sum=0;
        for(int i:n){
            sum+=i;
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        return new double[]{(double)sum/n.length,min,max};
    }
    public static void main(String[] args){
        int[] a=generate4DigitRandomArray(5);
        double[] r=findAverageMinMax(a);
        System.out.println(r[0]);
        System.out.println(r[1]);
        System.out.println(r[2]);
    }
}
