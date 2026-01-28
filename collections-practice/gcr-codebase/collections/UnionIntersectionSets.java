import java.util.*;
public class UnionIntersectionSets{
    static Set<Integer> union(Set<Integer> a,Set<Integer> b){
        Set<Integer> u=new HashSet<>(a);
        u.addAll(b);
        return u;
    }
    static Set<Integer> intersection(Set<Integer> a,Set<Integer> b){
        Set<Integer> i=new HashSet<>(a);
        i.retainAll(b);
        return i;
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
        Set<Integer> u=union(s1,s2);
        Set<Integer> i=intersection(s1,s2);
        System.out.println(u);
        System.out.println(i);
    }
}
