import java.util.*;
public class GenerateBinaryNumbers{
    static List<String> generate(int n){
        List<String> res=new ArrayList<>();
        Queue<String> q=new LinkedList<>();
        q.add("1");
        for(int i=0;i<n;i++){
            String s=q.remove();
            res.add(s);
            q.add(s+"0");
            q.add(s+"1");
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> result=generate(n);
        System.out.println(result);
    }
}
