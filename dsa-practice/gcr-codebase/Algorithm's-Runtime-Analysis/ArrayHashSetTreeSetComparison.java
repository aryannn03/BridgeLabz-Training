import java.util.*;

public class ArrayHashSetTreeSetComparison{
	public static void main(String[] args){
		int n=1_000_000;
		int target=n-1;

		int[] arr=new int[n];
		HashSet<Integer> hashSet=new HashSet<>();
		TreeSet<Integer> treeSet=new TreeSet<>();

		for(int i=0;i<n;i++){
			arr[i]=i;
			hashSet.add(i);
			treeSet.add(i);
		}

		long start,end;

		start=System.currentTimeMillis();
		linearSearch(arr,target);
		end=System.currentTimeMillis();
		System.out.println("Array Search Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		hashSet.contains(target);
		end=System.currentTimeMillis();
		System.out.println("HashSet Search Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		treeSet.contains(target);
		end=System.currentTimeMillis();
		System.out.println("TreeSet Search Time: "+(end-start)+" ms");
	}

	static boolean linearSearch(int[] arr,int target){
		for(int x:arr){
			if(x==target){
				return true;
			}
		}
		return false;
	}
}
