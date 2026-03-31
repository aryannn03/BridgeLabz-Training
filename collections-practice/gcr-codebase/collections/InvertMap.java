import java.util.*;
public class InvertMap{
    static Map<Integer,List<String>> invert(Map<String,Integer> map){
        Map<Integer,List<String>> res=new HashMap<>();
        for(Map.Entry<String,Integer> e:map.entrySet()){
            int v=e.getValue();
            String k=e.getKey();
            if(!res.containsKey(v)){
                res.put(v,new ArrayList<>());
            }
            res.get(v).add(k);
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(sc.next(),sc.nextInt());
        }
        Map<Integer,List<String>> result=invert(map);
        System.out.println(result);
    }
}
