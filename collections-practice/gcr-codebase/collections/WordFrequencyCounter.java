import java.util.*;
public class WordFrequencyCounter{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine().toLowerCase();
        Map<String,Integer> map=new HashMap<>();
        Scanner s=new Scanner(text);
        while(s.hasNext()){
            String w=s.next();
            w=w.replace(",","").replace("!","").replace(".","");
            map.put(w,map.getOrDefault(w,0)+1);
        }
        System.out.println(map);
    }
}
