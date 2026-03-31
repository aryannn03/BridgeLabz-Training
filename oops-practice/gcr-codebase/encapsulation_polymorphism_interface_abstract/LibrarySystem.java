interface Reservable{
    void reserveItem();
    boolean checkAvailability();
}
abstract class LibraryItem{
    protected int itemId;
    protected String title;
    protected String author;
    private boolean available=true;
    LibraryItem(int id,String t,String a){
        itemId=id;
        title=t;
        author=a;
    }
    abstract int getLoanDuration();
    void getItemDetails(){
        System.out.println(itemId+" "+title+" "+author);
    }
    public void reserveItem(){
        available=false;
    }
    public boolean checkAvailability(){
        return available;
    }
}
class Book extends LibraryItem{
    Book(int i,String t,String a){
        super(i,t,a);
    }
    int getLoanDuration(){
        return 14;
    }
}
class Magazine extends LibraryItem{
    Magazine(int i,String t,String a){
        super(i,t,a);
    }
    int getLoanDuration(){
        return 7;
    }
}
class DVD extends LibraryItem{
    DVD(int i,String t,String a){
        super(i,t,a);
    }
    int getLoanDuration(){
        return 3;
    }
}
public class LibrarySystem{
    public static void main(String[] args){
        LibraryItem item1=new Book(1,"Java","James");
        LibraryItem item2=new DVD(2,"Movie","Director");
        item1.getItemDetails();
        System.out.println("Loan Days:"+item1.getLoanDuration());
        item2.getItemDetails();
        System.out.println("Loan Days:"+item2.getLoanDuration());
    }
}
