import java.util.*;

public class CircularTour {
    static class PetrolPump{
        int petrol;
        int distance;
        PetrolPump(int petrol,int distance){
            this.petrol=petrol;
            this.distance=distance;
        }
    }
    public static void main(String[] args){
        PetrolPump[] arr={new PetrolPump(6,4),new PetrolPump(3,6),new PetrolPump(7,3)};
        System.out.print(findStart(arr));
    }
    public static int findStart(PetrolPump[] arr){
        int n=arr.length;
        Queue<Integer> q=new LinkedList<>();
        int start=0;
        int surplus=0;
        for(int i=0;i<n;i++){
            q.offer(i);
            surplus+=arr[i].petrol-arr[i].distance;
            while(surplus<0&&!q.isEmpty()){
                start=q.poll()+1;
                surplus=0;
            }
        }
        return surplus>=0?start:-1;
    }
}
