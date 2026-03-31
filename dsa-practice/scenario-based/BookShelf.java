import java.util.*;
class Book {
    String title;
    String author;
    Book(String title,String author){
        this.title=title;
        this.author=author;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null||getClass()!=obj.getClass()){
            return false;
        }
        Book book=(Book)obj;
        return title.equals(book.title)&&author.equals(book.author);
    }
    @Override
    public int hashCode(){
        return Objects.hash(title,author);
    }
    @Override
    public String toString(){
        return title+" by "+author;
    }
}
public class BookShelf {
    HashMap<String,LinkedList<Book>> catalog;
    HashSet<Book> bookSet;
    public BookShelf(){
        catalog=new HashMap<>();
        bookSet=new HashSet<>();
    }
    public void addBook(String genre,String title,String author){
        Book newBook=new Book(title,author);
        if(bookSet.contains(newBook)){
            System.out.println("Book already exists in library");
            return;
        }
        catalog.putIfAbsent(genre,new LinkedList<>());
        catalog.get(genre).add(newBook);
        bookSet.add(newBook);
        System.out.println("Book added successfully");
    }
    public void borrowBook(String genre,String title,String author){
        if(!catalog.containsKey(genre)){
            System.out.println("Genre not found");
            return;
        }
        LinkedList<Book> list=catalog.get(genre);
        Book target=new Book(title,author);
        if(list.remove(target)){
            bookSet.remove(target);
            System.out.println("Book borrowed successfully");
        }else{
            System.out.println("Book not available in this genre");
        }
    }
    public void returnBook(String genre,String title,String author){
        addBook(genre,title,author);
    }
    public void displayLibrary(){
        if(catalog.isEmpty()){
            System.out.println("Library is empty");
            return;
        }
        System.out.println("Library Catalog:");
        for(String genre:catalog.keySet()){
            System.out.println("Genre: "+genre);
            for(Book book:catalog.get(genre)){
                System.out.println("  - "+book);
            }
        }
    }
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        BookShelf library=new BookShelf();
        boolean running=true;
        while(running){
            System.out.println("Choose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Library");
            System.out.println("5. Exit");
            int choice=ob.nextInt();
            ob.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter genre:");
                    String genreAdd=ob.nextLine();
                    System.out.println("Enter book title:");
                    String titleAdd=ob.nextLine();
                    System.out.println("Enter author name:");
                    String authorAdd=ob.nextLine();
                    library.addBook(genreAdd,titleAdd,authorAdd);
                    break;
                case 2:
                    System.out.println("Enter genre:");
                    String genreBorrow=ob.nextLine();
                    System.out.println("Enter book title:");
                    String titleBorrow=ob.nextLine();
                    System.out.println("Enter author name:");
                    String authorBorrow=ob.nextLine();
                    library.borrowBook(genreBorrow,titleBorrow,authorBorrow);
                    break;
                case 3:
                    System.out.println("Enter genre:");
                    String genreReturn=ob.nextLine();
                    System.out.println("Enter book title:");
                    String titleReturn=ob.nextLine();
                    System.out.println("Enter author name:");
                    String authorReturn=ob.nextLine();
                    library.returnBook(genreReturn,titleReturn,authorReturn);
                    break;
                case 4:
                    library.displayLibrary();
                    break;
                case 5:
                    running=false;
                    System.out.println("Exiting Library System");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
