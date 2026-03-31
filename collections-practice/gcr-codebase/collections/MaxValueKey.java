import java.util.*;
public class MaxValueKey{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(sc.next(),sc.nextInt());
        }
        String maxKey=null;
        int max=Integer.MIN_VALUE;
        for(Map.Entry<String,Integer> e:map.entrySet()){
            if(e.getValue()>max){
                max=e.getValue();
                maxKey=e.getKey();
            }
        }
        System.out.println(maxKey);
    }
}
