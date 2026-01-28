import java.util.*;
public class BankingSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Integer> accounts=new HashMap<>();
        for(int i=0;i<n;i++){
            accounts.put(sc.nextInt(),sc.nextInt());
        }
        Queue<int[]> q=new LinkedList<>();
        int w=sc.nextInt();
        for(int i=0;i<w;i++){
            q.add(new int[]{sc.nextInt(),sc.nextInt()});
        }
        while(!q.isEmpty()){
            int[] r=q.remove();
            int acc=r[0];
            int amt=r[1];
            if(accounts.containsKey(acc)&&accounts.get(acc)>=amt){
                accounts.put(acc,accounts.get(acc)-amt);
            }
        }
        Map<Integer,List<Integer>> sorted=new TreeMap<>();
        for(int acc:accounts.keySet()){
            int bal=accounts.get(acc);
            if(!sorted.containsKey(bal)){
                sorted.put(bal,new ArrayList<>());
            }
            sorted.get(bal).add(acc);
        }
        System.out.println("FINAL_BALANCES");
        System.out.println(accounts);
        System.out.println("SORTED_BY_BALANCE");
        System.out.println(sorted);
    }
}
