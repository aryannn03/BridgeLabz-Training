import java.util.*;

class BookNotAvailableException extends Exception{
    BookNotAvailableException(String msg){
        super(msg);
    }
}

class Book{
    String title;
    String author;
    boolean available;
    Book(String title,String author){
        this.title=title;
        this.author=author;
        this.available=true;
    }
}

public class LibraryManagementSystem{
    static Book[]bookArray={
        new Book("Java Basics","James"),
        new Book("Data Structures","Mark"),
        new Book("Operating Systems","Silberschatz")
    };

    static List<Book>library=new ArrayList<>(Arrays.asList(bookArray));

    static void displayBooks(){
        for(Book b:library){
            System.out.println(b.title+" "+b.author+" "+(b.available?"Available":"Issued"));
        }
    }

    static void searchBook(String key){
        boolean found=false;
        for(Book b:library){
            if(b.title.toLowerCase().contains(key.toLowerCase())){
                System.out.println(b.title+" "+b.author+" "+(b.available?"Available":"Issued"));
                found=true;
            }
        }
        if(!found)System.out.println("No Book Found");
    }

    static void checkoutBook(String title)throws BookNotAvailableException{
        for(Book b:library){
            if(b.title.equalsIgnoreCase(title)){
                if(!b.available)throw new BookNotAvailableException("Book Not Available");
                b.available=false;
                System.out.println("Book Checked Out");
                return;
            }
        }
        System.out.println("Book Not Found");
    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Display 2.Search 3.Checkout 4.Exit");
            int ch=sc.nextInt();
            sc.nextLine();
            try{
                if(ch==1){
                    displayBooks();
                }
                else if(ch==2){
                    System.out.print("Enter title keyword:");
                    searchBook(sc.nextLine());
                }
                else if(ch==3){
                    System.out.print("Enter book title:");
                    checkoutBook(sc.nextLine());
                }
                else{
                    break;
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
