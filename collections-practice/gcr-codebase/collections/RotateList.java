import java.util.*;
public class RotateList{
    static void rotate(List<Integer> list,int k){
        int n=list.size();
        k=k%n;
        reverse(list,0,k-1);
        reverse(list,k,n-1);
        reverse(list,0,n-1);
    }
    static void reverse(List<Integer> list,int i,int j){
        while(i<j){
            int t=list.get(i);
            list.set(i,list.get(j));
            list.set(j,t);
            i++;
            j--;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        int k=sc.nextInt();
        rotate(list,k);
        System.out.println(list);
    }
}
