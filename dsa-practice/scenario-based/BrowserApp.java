import java.util.*;
class Page {
    String url;
    Page prev;
    Page next;
    Page(String url){
        this.url=url;
        this.prev=null;
        this.next=null;
    }
}
class BrowserBuddy {
    Page current;
    Stack<Page> closedTabs;
    BrowserBuddy(){
        current=null;
        closedTabs=new Stack<>();
    }
    public void visit(String url){
        Page newPage=new Page(url);
        if(current==null){
            current=newPage;
        }else{
            current.next=newPage;
            newPage.prev=current;
            current=newPage;
        }
        System.out.println("Visited: "+url);
    }
    public void back(){
        if(current==null||current.prev==null){
            System.out.println("No previous page available");
            return;
        }
        current=current.prev;
        System.out.println("Back to: "+current.url);
    }
    public void forward(){
        if(current==null||current.next==null){
            System.out.println("No forward page available");
            return;
        }
        current=current.next;
        System.out.println("Forward to: "+current.url);
    }
    public void closeTab(){
        if(current==null){
            System.out.println("No tab to close");
            return;
        }
        closedTabs.push(current);
        System.out.println("Closed tab: "+current.url);
        if(current.prev!=null){
            current=current.prev;
            current.next=null;
        }else{
            current=null;
        }
    }
    public void restoreTab(){
        if(closedTabs.isEmpty()){
            System.out.println("No closed tabs to restore");
            return;
        }
        Page restored=closedTabs.pop();
        if(current==null){
            current=restored;
            restored.prev=null;
            restored.next=null;
        }else{
            current.next=restored;
            restored.prev=current;
            restored.next=null;
            current=restored;
        }
        System.out.println("Restored tab: "+restored.url);
    }
    public void showHistory(){
        if(current==null){
            System.out.println("No browsing history");
            return;
        }
        Page temp=current;
        while(temp.prev!=null){
            temp=temp.prev;
        }
        System.out.println("Browsing History:");
        while(temp!=null){
            if(temp==current){
                System.out.println("-> "+temp.url+" (Current)");
            }else{
                System.out.println("   "+temp.url);
            }
            temp=temp.next;
        }
    }
}
public class BrowserApp {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        BrowserBuddy browser=new BrowserBuddy();
        boolean running=true;
        while(running){
            System.out.println("Choose an option:");
            System.out.println("1. Visit New Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Close Tab");
            System.out.println("5. Restore Closed Tab");
            System.out.println("6. Show History");
            System.out.println("7. Exit");
            int choice=ob.nextInt();
            ob.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter URL:");
                    String url=ob.nextLine();
                    browser.visit(url);
                    break;
                case 2:
                    browser.back();
                    break;
                case 3:
                    browser.forward();
                    break;
                case 4:
                    browser.closeTab();
                    break;
                case 5:
                    browser.restoreTab();
                    break;
                case 6:
                    browser.showHistory();
                    break;
                case 7:
                    running=false;
                    System.out.println("Exiting BrowserBuddy");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
