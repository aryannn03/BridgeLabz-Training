import java.util.Scanner;

class Student{
    int roll;
    String name;
    int age;
    char grade;
    Student next;

    Student(int roll,String name,int age,char grade){
        this.roll=roll;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.next=null;
    }
}

class StudentLinkedList{
    private Student head;

    void addAtBeginning(int roll,String name,int age,char grade){
        Student newNode=new Student(roll,name,age,grade);
        newNode.next=head;
        head=newNode;
    }

    void addAtEnd(int roll,String name,int age,char grade){
        Student newNode=new Student(roll,name,age,grade);
        if(head==null){
            head=newNode;
            return;
        }
        Student temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    void addAtPosition(int pos,int roll,String name,int age,char grade){
        if(pos<=0){
            System.out.println("Invalid position");
            return;
        }
        if(pos==1){
            addAtBeginning(roll,name,age,grade);
            return;
        }
        Student temp=head;
        for(int i=1;i<pos-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Position out of range");
            return;
        }
        Student newNode=new Student(roll,name,age,grade);
        newNode.next=temp.next;
        temp.next=newNode;
    }

    void deleteByRoll(int roll){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.roll==roll){
            head=head.next;
            System.out.println("Student deleted");
            return;
        }
        Student temp=head;
        while(temp.next!=null&&temp.next.roll!=roll){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Student not found");
        }else{
            temp.next=temp.next.next;
            System.out.println("Student deleted");
        }
    }

    void search(int roll){
        Student temp=head;
        while(temp!=null){
            if(temp.roll==roll){
                System.out.println("Roll:"+temp.roll+",Name:"+temp.name+",Age:"+temp.age+",Grade:"+temp.grade);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Student not found");
    }

    void updateGrade(int roll,char newGrade){
        Student temp=head;
        while(temp!=null){
            if(temp.roll==roll){
                temp.grade=newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Student not found");
    }

    void display(){
        if(head==null){
            System.out.println("No student records");
            return;
        }
        Student temp=head;
        while(temp!=null){
            System.out.println("Roll:"+temp.roll+",Name:"+temp.name+",Age:"+temp.age+",Grade:"+temp.grade);
            temp=temp.next;
        }
    }
}

public class StudentRecordManagement{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StudentLinkedList list=new StudentLinkedList();

        while(true){
            System.out.println("1AddBegin 2AddEnd 3AddPos 4Delete 5Search 6Update 7Display 8Exit");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    list.addAtBeginning(sc.nextInt(),sc.next(),sc.nextInt(),sc.next().charAt(0));
                    break;
                case 2:
                    list.addAtEnd(sc.nextInt(),sc.next(),sc.nextInt(),sc.next().charAt(0));
                    break;
                case 3:
                    list.addAtPosition(sc.nextInt(),sc.nextInt(),sc.next(),sc.nextInt(),sc.next().charAt(0));
                    break;
                case 4:
                    list.deleteByRoll(sc.nextInt());
                    break;
                case 5:
                    list.search(sc.nextInt());
                    break;
                case 6:
                    list.updateGrade(sc.nextInt(),sc.next().charAt(0));
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
