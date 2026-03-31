import java.util.*;
class CircularBuffer{
    int[] arr;
    int size;
    int head;
    int count;
    CircularBuffer(int size){
        this.size=size;
        arr=new int[size];
        head=0;
        count=0;
    }
    void add(int x){
        arr[(head+count)%size]=x;
        if(count<size){
            count++;
        }else{
            head=(head+1)%size;
        }
    }
    void print(){
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<count;i++){
            res.add(arr[(head+i)%size]);
        }
        System.out.println(res);
    }
}
public class CircularBufferSimulation{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int q=sc.nextInt();
        CircularBuffer cb=new CircularBuffer(size);
        for(int i=0;i<q;i++){
            String op=sc.next();
            if(op.equals("add")){
                cb.add(sc.nextInt());
            }else if(op.equals("print")){
                cb.print();
            }
        }
    }
}
