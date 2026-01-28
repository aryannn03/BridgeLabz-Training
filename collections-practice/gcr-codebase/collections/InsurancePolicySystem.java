import java.util.*;
import java.time.*;
class Policy{
    int number;
    String name;
    LocalDate expiry;
    String coverage;
    double premium;
    Policy(int number,String name,LocalDate expiry,String coverage,double premium){
        this.number=number;
        this.name=name;
        this.expiry=expiry;
        this.coverage=coverage;
        this.premium=premium;
    }
    public boolean equals(Object o){
        if(this==o)return true;
        if(o==null||getClass()!=o.getClass())return false;
        Policy p=(Policy)o;
        return number==p.number;
    }
    public int hashCode(){
        return Objects.hash(number);
    }
    public String toString(){
        return number+" "+name+" "+expiry+" "+coverage+" "+premium;
    }
}
public class InsurancePolicySystem{
    static void expiringSoon(Set<Policy> set){
        LocalDate now=LocalDate.now();
        for(Policy p:set){
            if(!p.expiry.isBefore(now)&&!p.expiry.isAfter(now.plusDays(30))){
                System.out.println(p);
            }
        }
    }
    static void byCoverage(Set<Policy> set,String type){
        for(Policy p:set){
            if(p.coverage.equalsIgnoreCase(type)){
                System.out.println(p);
            }
        }
    }
    static void duplicates(List<Policy> list){
        Set<Integer> seen=new HashSet<>();
        for(Policy p:list){
            if(!seen.add(p.number)){
                System.out.println(p);
            }
        }
    }
    static void performance(Set<Policy> set,Policy sample){
        long s1=System.nanoTime();
        set.add(sample);
        long s2=System.nanoTime();
        set.contains(sample);
        long s3=System.nanoTime();
        set.remove(sample);
        long s4=System.nanoTime();
        System.out.println((s2-s1)+" "+(s3-s2)+" "+(s4-s3));
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Set<Policy> hash=new HashSet<>();
        Set<Policy> linked=new LinkedHashSet<>();
        Set<Policy> tree=new TreeSet<>((a,b)->a.expiry.equals(b.expiry)?a.number-b.number:a.expiry.compareTo(b.expiry));
        List<Policy> all=new ArrayList<>();
        for(int i=0;i<n;i++){
            int no=sc.nextInt();
            String name=sc.next();
            LocalDate d=LocalDate.parse(sc.next());
            String c=sc.next();
            double pr=sc.nextDouble();
            Policy p=new Policy(no,name,d,c,pr);
            hash.add(p);
            linked.add(p);
            tree.add(p);
            all.add(p);
        }
        String search=sc.next();
        System.out.println("ALL");
        for(Policy p:hash)System.out.println(p);
        System.out.println("EXPIRING");
        expiringSoon(hash);
        System.out.println("COVERAGE");
        byCoverage(hash,search);
        System.out.println("DUPLICATES");
        duplicates(all);
        Policy sample=new Policy(999,"X",LocalDate.now(),"Test",1000);
        System.out.println("HASHSET");
        performance(hash,sample);
        System.out.println("LINKEDHASHSET");
        performance(linked,sample);
        System.out.println("TREESET");
        performance(tree,sample);
    }
}
