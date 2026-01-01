class Book{
    private static String libraryName="Egmore Library";

    private final String isbn;
    private String title;
    private String author;

    Book(String title,String author,String isbn){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
    }

    static void displayLibraryName(){
        System.out.println("Library Name: "+libraryName);
    }

    void display(){
        if(this instanceof Book){
            System.out.println("Title: "+title);
            System.out.println("Author: "+author);
            System.out.println("ISBN: "+isbn);
        }
    }
}

public class LibraryMain{
    public static void main(String[]args){
        Book b=new Book("Effective Java","Joshua Bloch","978-0134685991");
        Book.displayLibraryName();
        b.display();
    }
}
