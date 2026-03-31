import java.util.*;
public class FrequencyOfElements{
    static Map<String,Integer> frequency(List<String> list){
        Map<String,Integer> map=new HashMap<>();
        for(String s:list){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return map;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.next());
        }
        Map<String,Integer> result=frequency(list);
        System.out.println(result);
    }
}
