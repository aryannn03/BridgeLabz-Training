import java.util.List;

public class ListManager{
    public void addElement(List<Integer> list,int element){
        list.add(element);
    }
    public void removeElement(List<Integer> list,int element){
        list.remove(Integer.valueOf(element));
    }
    public int getSize(List<Integer> list){
        return list.size();
    }
    public static void main(String[]args){
        ListManager m=new ListManager();
        java.util.List<Integer> list=new java.util.ArrayList<>();
        m.addElement(list,10);
        m.addElement(list,20);
        m.removeElement(list,10);
        System.out.println(m.getSize(list));
    }
}
