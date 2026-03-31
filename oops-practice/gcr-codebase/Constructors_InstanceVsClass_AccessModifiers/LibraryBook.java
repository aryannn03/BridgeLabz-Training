public class LibraryBook{
    String title;
    String author;
    double price;
    boolean available;

    public LibraryBook(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
        available=true;
    }

    void borrowBook(){
        if(available){
            available=false;
            System.out.println("Book Borrowed");
        }else{
            System.out.println("Not Available");
        }
    }

    public static void main(String[]args){
        LibraryBook b=new LibraryBook("DSA","Mark",400);
        b.borrowBook();
        b.borrowBook();
    }
}
