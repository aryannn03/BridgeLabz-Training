import java.util.*;
public class MergeTwoMaps{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<String,Integer> map1=new HashMap<>();
        for(int i=0;i<n;i++){
            map1.put(sc.next(),sc.nextInt());
        }
        int m=sc.nextInt();
        Map<String,Integer> map2=new HashMap<>();
        for(int i=0;i<m;i++){
            String k=sc.next();
            int v=sc.nextInt();
            map1.put(k,map1.getOrDefault(k,0)+v);
        }
        System.out.println(map1);
    }
}
