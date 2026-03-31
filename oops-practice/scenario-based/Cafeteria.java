import java.util.*;
public class Cafeteria{
    static void displayMenu(String[] items){
        System.out.println("Cafeteria Menu:");
        for(int i=0;i<items.length;i++){
            System.out.println(i+" : "+items[i]);
        }
    }
    static String getItemByIndex(String[] items,int index){
        if(index<0||index>=items.length){
            return "Invalid item selection";
        }
        return items[index];
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        String[] menuItems={"Idli","Dosa","Vada","Pav Bhaji","Fried Rice","Veg Thali","Sandwich","Burger","Pasta","Coffee"};
        displayMenu(menuItems);
        System.out.print("Enter item index to order:");
        int choice=ob.nextInt();
        String selectedItem=getItemByIndex(menuItems,choice);
        System.out.println("You selected:"+selectedItem);
    }
}
