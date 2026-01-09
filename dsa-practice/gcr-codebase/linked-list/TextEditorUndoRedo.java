import java.util.Scanner;

class TextState{
    String text;
    TextState next;
    TextState prev;

    TextState(String text){
        this.text=text;
        this.next=null;
        this.prev=null;
    }
}

class UndoRedoList{
    private TextState head;
    private TextState tail;
    private TextState current;
    private int size;
    private final int LIMIT=10;

    void addState(String text){
        TextState newNode=new TextState(text);
        if(head==null){
            head=tail=current=newNode;
            size=1;
            return;
        }
        while(current.next!=null){
            current=current.next;
            removeFromEnd();
        }
        current.next=newNode;
        newNode.prev=current;
        tail=newNode;
        current=newNode;
        size++;
        if(size>LIMIT){
            removeFromBeginning();
        }
    }

    void undo(){
        if(current!=null&&current.prev!=null){
            current=current.prev;
        }else{
            System.out.println("No undo available");
        }
    }

    void redo(){
        if(current!=null&&current.next!=null){
            current=current.next;
        }else{
            System.out.println("No redo available");
        }
    }

    void displayCurrent(){
        if(current==null){
            System.out.println("Empty");
            return;
        }
        System.out.println("CurrentText:"+current.text);
    }

    void removeFromBeginning(){
        if(head==null){
            return;
        }
        if(head==tail){
            head=tail=current=null;
            size=0;
            return;
        }
        head=head.next;
        head.prev=null;
        size--;
    }

    void removeFromEnd(){
        if(tail==null){
            return;
        }
        if(head==tail){
            head=tail=current=null;
            size=0;
            return;
        }
        tail=tail.prev;
        tail.next=null;
        size--;
    }
}

public class TextEditorUndoRedo{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        UndoRedoList editor=new UndoRedoList();

        while(true){
            System.out.println("1Type 2Undo 3Redo 4Display 5Exit");
            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    editor.addState(sc.nextLine());
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrent();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
