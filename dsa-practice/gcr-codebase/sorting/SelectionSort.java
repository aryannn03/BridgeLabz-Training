public class SelectionSort{
    public static void main(String[] args){
        int[] scores={56,89,23,67,45,90};
        selectionSort(scores);
        for(int i=0;i<scores.length;i++){
            System.out.print(scores[i]);
        }
    }
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }
}
