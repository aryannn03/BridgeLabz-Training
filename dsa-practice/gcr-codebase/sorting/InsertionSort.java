public class InsertionSort{
    public static void main(String[] args){
        int[] ids={104,102,109,101,105};
        insertionSort(ids);
        for(int i=0;i<ids.length;i++){
            System.out.print(ids[i]);
        }
    }
    public static void insertionSort(int[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}
