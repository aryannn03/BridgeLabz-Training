import java.util.*;
public class SymmetricDifference{
    static Set<Integer> diff(Set<Integer> a,Set<Integer> b){
        Set<Integer> r=new HashSet<>(a);
        for(int x:b){
            if(!r.add(x)){
                r.remove(x);
            }
        }
        return r;
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
        Set<Integer> result=diff(s1,s2);
        System.out.println(result);
    }
}
