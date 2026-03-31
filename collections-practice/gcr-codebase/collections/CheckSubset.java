import java.util.*;
public class CheckSubset{
    static boolean isSubset(Set<Integer> a,Set<Integer> b){
        return b.containsAll(a);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Set<Integer> s1=new HashSet<>();
        for(int i=0;i<n;i++){
            s1.add(sc.nextInt());
        }
        int m=sc.nextInt();
        Set<Integer> s2=new HashSet<>();
        for(int i=0;i<m;i++){
            s2.add(sc.nextInt());
        }
        System.out.println(isSubset(s1,s2));
    }
}
