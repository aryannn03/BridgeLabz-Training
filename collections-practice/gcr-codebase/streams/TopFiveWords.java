import java.util.*;
import java.io.*;
public class TopFiveWords{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String path=sc.nextLine();
        Map<String,Integer> map=new HashMap<>();
        try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            String line;
            while((line=br.readLine())!=null){
                String[] words=line.toLowerCase().split("\\s+");
                for(String w:words){
                    w=w.replaceAll("[^a-z]","");
                    if(w.length()>0){
                        map.put(w,map.getOrDefault(w,0)+1);
                    }
                }
            }
            br.close();
            List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
            list.sort((a,b)->b.getValue()-a.getValue());
            int limit=Math.min(5,list.size());
            for(int i=0;i<limit;i++){
                System.out.println(list.get(i).getKey()+" "+list.get(i).getValue());
            }
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}
