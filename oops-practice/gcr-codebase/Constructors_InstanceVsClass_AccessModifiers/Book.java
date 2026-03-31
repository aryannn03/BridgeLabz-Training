public class Book{
    String title;
    String author;
    double price;

    public Book(){
        title="Unknown";
        author="Unknown";
        price=0;
    }

    public Book(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    void display(){
        System.out.println(title+" "+author+" "+price);
    }

    public static void main(String[]args){
        Book b1=new Book();
        Book b2=new Book("Java","James",500);
        b1.display();
        b2.display();
    }
}
