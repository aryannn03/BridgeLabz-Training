import java.util.*;
public class SuppressWarningsDemo{
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        ArrayList list=new ArrayList();
        list.add("Hello");
        list.add(10);
        System.out.println(list);
    }
}
