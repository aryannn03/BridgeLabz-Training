import java.util.*;
class Patient{
    String name;
    int severity;
    Patient(String name,int severity){
        this.name=name;
        this.severity=severity;
    }
    public String toString(){
        return name;
    }
}
public class HospitalTriageSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<Patient> pq=new PriorityQueue<>((a,b)->b.severity-a.severity);
        for(int i=0;i<n;i++){
            String name=sc.next();
            int severity=sc.nextInt();
            pq.add(new Patient(name,severity));
        }
        while(!pq.isEmpty()){
            System.out.print(pq.remove());
            if(!pq.isEmpty()){
                System.out.print(" ");
            }
        }
    }
}
