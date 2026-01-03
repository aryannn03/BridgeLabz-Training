class Book {
    String title;
    int pubYear;

    Book(String t,int y){
        title=t;
        pubYear=y;
    }
}

class Author extends Book {
    String name;
    String bio;

    Author(String t,int y,String n,String b){
        super(t,y);
        name=n;
        bio=b;
    }

    void displayInfo(){
        System.out.println("Title: "+title);
        System.out.println("Year: "+pubYear);
        System.out.println("Author: "+name);
        System.out.println("Bio: "+bio);
    }
}

public class Main {
    public static void main(String[] args){
        Author a=new Author("Java Basics",2023,"Naman","Java Trainer");
        a.displayInfo();
    }
}
