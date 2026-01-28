import java.util.*;
public class SetToSortedList{
    static List<Integer> convert(Set<Integer> set){
        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(sc.nextInt());
        }
        List<Integer> result=convert(set);
        System.out.println(result);
    }
}
