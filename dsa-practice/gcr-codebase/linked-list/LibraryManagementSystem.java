import java.util.Scanner;

class Book{
    int id;
    String title;
    String author;
    String genre;
    boolean available;
    Book next;
    Book prev;

    Book(int id,String title,String author,String genre,boolean available){
        this.id=id;
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.available=available;
        this.next=null;
        this.prev=null;
    }
}

class LibraryList{
    private Book head;
    private Book tail;

    void addAtBeginning(int id,String title,String author,String genre,boolean available){
        Book newNode=new Book(id,title,author,genre,available);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    void addAtEnd(int id,String title,String author,String genre,boolean available){
        Book newNode=new Book(id,title,author,genre,available);
        if(tail==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }

    void addAtPosition(int pos,int id,String title,String author,String genre,boolean available){
        if(pos<=0){
            System.out.println("Invalid position");
            return;
        }
        if(pos==1){
            addAtBeginning(id,title,author,genre,available);
            return;
        }
        Book temp=head;
        for(int i=1;i<pos-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null||temp.next==null){
            addAtEnd(id,title,author,genre,available);
            return;
        }
        Book newNode=new Book(id,title,author,genre,available);
        newNode.next=temp.next;
        newNode.prev=temp;
        temp.next.prev=newNode;
        temp.next=newNode;
    }

    void removeById(int id){
        if(head==null){
            System.out.println("Library empty");
            return;
        }
        Book temp=head;
        while(temp!=null&&temp.id!=id){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Book not found");
            return;
        }
        if(temp==head){
            head=head.next;
            if(head!=null){
                head.prev=null;
            }else{
                tail=null;
            }
        }else if(temp==tail){
            tail=tail.prev;
            tail.next=null;
        }else{
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
        }
        System.out.println("Book removed");
    }

    void searchByTitle(String title){
        Book temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.title.equals(title)){
                printBook(temp);
                found=true;
            }
            temp=temp.next;
        }
        if(!found){
            System.out.println("Book not found");
        }
    }

    void searchByAuthor(String author){
        Book temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.author.equals(author)){
                printBook(temp);
                found=true;
            }
            temp=temp.next;
        }
        if(!found){
            System.out.println("Book not found");
        }
    }

    void updateAvailability(int id,boolean status){
        Book temp=head;
        while(temp!=null){
            if(temp.id==id){
                temp.available=status;
                System.out.println("Availability updated");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Book not found");
    }

    void displayForward(){
        if(head==null){
            System.out.println("No books");
            return;
        }
        Book temp=head;
        while(temp!=null){
            printBook(temp);
            temp=temp.next;
        }
    }

    void displayReverse(){
        if(tail==null){
            System.out.println("No books");
            return;
        }
        Book temp=tail;
        while(temp!=null){
            printBook(temp);
            temp=temp.prev;
        }
    }

    void countBooks(){
        int count=0;
        Book temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println("TotalBooks:"+count);
    }

    private void printBook(Book b){
        System.out.println("Id:"+b.id+",Title:"+b.title+",Author:"+b.author+",Genre:"+b.genre+",Available:"+b.available);
    }
}

public class LibraryManagementSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LibraryList list=new LibraryList();

        while(true){
            System.out.println("1AddBegin 2AddEnd 3AddPos 4Remove 5SearchTitle 6SearchAuthor 7UpdateAvail 8DisplayF 9DisplayR 10Count 11Exit");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    list.addAtBeginning(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.nextBoolean());
                    break;
                case 2:
                    list.addAtEnd(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.nextBoolean());
                    break;
                case 3:
                    list.addAtPosition(sc.nextInt(),sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.nextBoolean());
                    break;
                case 4:
                    list.removeById(sc.nextInt());
                    break;
                case 5:
                    list.searchByTitle(sc.next());
                    break;
                case 6:
                    list.searchByAuthor(sc.next());
                    break;
                case 7:
                    list.updateAvailability(sc.nextInt(),sc.nextBoolean());
                    break;
                case 8:
                    list.displayForward();
                    break;
                case 9:
                    list.displayReverse();
                    break;
                case 10:
                    list.countBooks();
                    break;
                case 11:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
