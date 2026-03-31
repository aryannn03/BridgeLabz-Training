import java.util.*;
public class NthFromEnd{
    static String find(LinkedList<String> list,int k){
        Iterator<String> fast=list.iterator();
        Iterator<String> slow=list.iterator();
        for(int i=0;i<k;i++){
            if(!fast.hasNext()){
                return null;
            }
            fast.next();
        }
        while(fast.hasNext()){
            fast.next();
            slow.next();
        }
        return slow.next();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        LinkedList<String> list=new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(sc.next());
        }
        int k=sc.nextInt();
        String result=find(list,k);
        System.out.println(result);
    }
}
