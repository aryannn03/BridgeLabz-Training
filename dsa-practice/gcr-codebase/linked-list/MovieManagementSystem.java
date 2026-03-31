import java.util.Scanner;

class Movie{
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title,String director,int year,double rating){
        this.title=title;
        this.director=director;
        this.year=year;
        this.rating=rating;
        this.next=null;
        this.prev=null;
    }
}

class MovieDoublyLinkedList{
    private Movie head;
    private Movie tail;

    void addAtBeginning(String title,String director,int year,double rating){
        Movie newNode=new Movie(title,director,year,rating);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    void addAtEnd(String title,String director,int year,double rating){
        Movie newNode=new Movie(title,director,year,rating);
        if(tail==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }

    void addAtPosition(int pos,String title,String director,int year,double rating){
        if(pos<=0){
            System.out.println("Invalid position");
            return;
        }
        if(pos==1){
            addAtBeginning(title,director,year,rating);
            return;
        }
        Movie temp=head;
        for(int i=1;i<pos-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null||temp.next==null){
            addAtEnd(title,director,year,rating);
            return;
        }
        Movie newNode=new Movie(title,director,year,rating);
        newNode.next=temp.next;
        newNode.prev=temp;
        temp.next.prev=newNode;
        temp.next=newNode;
    }

    void removeByTitle(String title){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Movie temp=head;
        while(temp!=null&&!temp.title.equals(title)){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Movie not found");
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
        System.out.println("Movie removed");
    }

    void searchByDirector(String director){
        Movie temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.director.equals(director)){
                printMovie(temp);
                found=true;
            }
            temp=temp.next;
        }
        if(!found){
            System.out.println("Movie not found");
        }
    }

    void searchByRating(double rating){
        Movie temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.rating==rating){
                printMovie(temp);
                found=true;
            }
            temp=temp.next;
        }
        if(!found){
            System.out.println("Movie not found");
        }
    }

    void updateRating(String title,double newRating){
        Movie temp=head;
        while(temp!=null){
            if(temp.title.equals(title)){
                temp.rating=newRating;
                System.out.println("Rating updated");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Movie not found");
    }

    void displayForward(){
        if(head==null){
            System.out.println("No movie records");
            return;
        }
        Movie temp=head;
        while(temp!=null){
            printMovie(temp);
            temp=temp.next;
        }
    }

    void displayReverse(){
        if(tail==null){
            System.out.println("No movie records");
            return;
        }
        Movie temp=tail;
        while(temp!=null){
            printMovie(temp);
            temp=temp.prev;
        }
    }

    private void printMovie(Movie m){
        System.out.println("Title:"+m.title+",Director:"+m.director+",Year:"+m.year+",Rating:"+m.rating);
    }
}

public class MovieManagementSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        MovieDoublyLinkedList list=new MovieDoublyLinkedList();

        while(true){
            System.out.println("1AddBegin 2AddEnd 3AddPos 4Remove 5SearchDirector 6SearchRating 7Update 8DisplayF 9DisplayR 10Exit");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    list.addAtBeginning(sc.next(),sc.next(),sc.nextInt(),sc.nextDouble());
                    break;
                case 2:
                    list.addAtEnd(sc.next(),sc.next(),sc.nextInt(),sc.nextDouble());
                    break;
                case 3:
                    list.addAtPosition(sc.nextInt(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble());
                    break;
                case 4:
                    list.removeByTitle(sc.next());
                    break;
                case 5:
                    list.searchByDirector(sc.next());
                    break;
                case 6:
                    list.searchByRating(sc.nextDouble());
                    break;
                case 7:
                    list.updateRating(sc.next(),sc.nextDouble());
                    break;
                case 8:
                    list.displayForward();
                    break;
                case 9:
                    list.displayReverse();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
