import java.util.*;
public class VotingSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<String,Integer> hash=new HashMap<>();
        Map<String,Integer> linked=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            String c=sc.next();
            hash.put(c,hash.getOrDefault(c,0)+1);
            linked.put(c,linked.getOrDefault(c,0)+1);
        }
        System.out.println("VOTES_IN_ORDER");
        System.out.println(linked);
        System.out.println("SORTED_RESULTS");
        Map<String,Integer> tree=new TreeMap<>(hash);
        System.out.println(tree);
    }
}
