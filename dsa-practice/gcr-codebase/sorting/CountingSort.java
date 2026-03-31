public class CountingSort{
    public static void main(String[] args){
        int[] ages={12,15,10,18,14,12,16,11,10};
        countingSort(ages,10,18);
        for(int i=0;i<ages.length;i++){
            System.out.print(ages[i]);
        }
    }
    public static void countingSort(int[] arr,int min,int max){
        int range=max-min+1;
        int[] count=new int[range];
        int[] output=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            count[arr[i]-min]++;
        }
        for(int i=1;i<range;i++){
            count[i]+=count[i-1];
        }
        for(int i=arr.length-1;i>=0;i--){
            output[count[arr[i]-min]-1]=arr[i];
            count[arr[i]-min]--;
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=output[i];
        }
    }
}
