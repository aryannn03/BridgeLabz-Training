import java.util.*;
public class SortingComparison{
	public static void main(String[] args){
		int n=100000;
		int[] arr=new int[n];
		Random r=new Random();

		for(int i=0;i<n;i++){
			arr[i]=r.nextInt(n);
		}

		int[] a1=arr.clone();
		int[] a2=arr.clone();
		int[] a3=arr.clone();

		long start,end;

		start=System.currentTimeMillis();
		bubbleSort(a1);
		end=System.currentTimeMillis();
		System.out.println("Bubble Sort Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		mergeSort(a2,0,a2.length-1);
		end=System.currentTimeMillis();
		System.out.println("Merge Sort Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		quickSort(a3,0,a3.length-1);
		end=System.currentTimeMillis();
		System.out.println("Quick Sort Time: "+(end-start)+" ms");
	}
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
	}

	public static void mergeSort(int[] arr,int l,int r){
		if(l<r){
			int m=(l+r)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}
	public static void merge(int[] arr,int l,int m,int r){
		int[] temp=new int[r-l+1];
		int i=l,j=m+1,k=0;

		while(i<=m&&j<=r){
			temp[k++]=arr[i]<=arr[j]?arr[i++]:arr[j++];
		}
		while(i<=m)temp[k++]=arr[i++];
		while(j<=r)temp[k++]=arr[j++];

		for(i=0;i<temp.length;i++){
			arr[l+i]=temp[i];
		}
	}

	public static void quickSort(int[] arr,int low,int high){
		if(low<high){
			int pi=partition(arr,low,high);
			quickSort(arr,low,pi-1);
			quickSort(arr,pi+1,high);
		}
	}

	public static int partition(int[] arr,int low,int high){
		int pivot=arr[high];
		int i=low-1;

		for(int j=low;j<high;j++){
			if(arr[j]<=pivot){
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;

		return i+1;
	}
}
