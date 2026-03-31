public class BubbleSort{
    public static void main(String[] args){
        int[] marks={45,78,12,89,34,67};
        bubbleSort(marks);
        for(int i=0;i<marks.length;i++){
            System.out.print(marks[i]);
        }
    }
    public static void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            boolean swapped=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}
