import java.util.*;
public class RemoveDuplicates{
    static List<Integer> remove(List<Integer> list){
        Set<Integer> set=new LinkedHashSet<>();
        for(int x:list){
            set.add(x);
        }
        return new ArrayList<>(set);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        List<Integer> result=remove(list);
        System.out.println(result);
    }
}
