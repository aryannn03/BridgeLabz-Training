import java.util.*;
public class ReverseList{
    static void reverseArrayList(ArrayList<Integer> list){
        int i=0;
        int j=list.size()-1;
        while(i<j){
            int t=list.get(i);
            list.set(i,list.get(j));
            list.set(j,t);
            i++;
            j--;
        }
    }
    static void reverseLinkedList(LinkedList<Integer> list){
        int i=0;
        int j=list.size()-1;
        while(i<j){
            int t=list.get(i);
            list.set(i,list.get(j));
            list.set(j,t);
            i++;
            j--;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> a=new ArrayList<>();
        LinkedList<Integer> l=new LinkedList<>();
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            a.add(x);
            l.add(x);
        }
        reverseArrayList(a);
        reverseLinkedList(l);
        System.out.println(a);
        System.out.println(l);
    }
}
