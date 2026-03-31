import java.util.*;
import java.time.*;
class Policy{
    int number;
    String holder;
    LocalDate expiry;
    Policy(int number,String holder,LocalDate expiry){
        this.number=number;
        this.holder=holder;
        this.expiry=expiry;
    }
    public String toString(){
        return number+" "+holder+" "+expiry;
    }
}
public class InsurancePolicyManagement{
    static void expiringSoon(Map<Integer,Policy> map){
        LocalDate now=LocalDate.now();
        for(Policy p:map.values()){
            if(!p.expiry.isBefore(now)&&!p.expiry.isAfter(now.plusDays(30))){
                System.out.println(p);
            }
        }
    }
    static void byHolder(Map<Integer,Policy> map,String name){
        for(Policy p:map.values()){
            if(p.holder.equalsIgnoreCase(name)){
                System.out.println(p);
            }
        }
    }
    static void removeExpired(Map<Integer,Policy> map){
        Iterator<Policy> it=map.values().iterator();
        LocalDate now=LocalDate.now();
        while(it.hasNext()){
            if(it.next().expiry.isBefore(now)){
                it.remove();
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Policy> hash=new HashMap<>();
        Map<Integer,Policy> linked=new LinkedHashMap<>();
        Map<LocalDate,List<Policy>> tree=new TreeMap<>();
        for(int i=0;i<n;i++){
            int no=sc.nextInt();
            String name=sc.next();
            LocalDate d=LocalDate.parse(sc.next());
            Policy p=new Policy(no,name,d);
            hash.put(no,p);
            linked.put(no,p);
            tree.computeIfAbsent(d,k->new ArrayList<>()).add(p);
        }
        int searchNo=sc.nextInt();
        String searchName=sc.next();
        System.out.println(hash.get(searchNo));
        expiringSoon(hash);
        byHolder(hash,searchName);
        removeExpired(hash);
        for(Policy p:hash.values()){
            System.out.println(p);
        }
    }
}
