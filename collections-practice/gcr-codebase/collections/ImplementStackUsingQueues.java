import java.util.*;
class StackUsingQueues{
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();
    void push(int x){
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> t=q1;
        q1=q2;
        q2=t;
    }
    int pop(){
        return q1.remove();
    }
    int top(){
        return q1.peek();
    }
}
public class ImplementStackUsingQueues{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        StackUsingQueues s=new StackUsingQueues();
        for(int i=0;i<q;i++){
            String op=sc.next();
            if(op.equals("push")){
                s.push(sc.nextInt());
            }else if(op.equals("pop")){
                System.out.println(s.pop());
            }else if(op.equals("top")){
                System.out.println(s.top());
            }
        }
    }
}
