import java.util.*;

class InvalidPhoneNumberException extends Exception{
    InvalidPhoneNumberException(String msg){
        super(msg);
    }
}
class Contact{
    String name;
    String phone;
    Contact(String name,String phone){
        this.name=name;
        this.phone=phone;
    }
}
public class PhoneContactOrganizer{
    static List<Contact>contacts=new ArrayList<>();
    static void addContact(String name,String phone)throws InvalidPhoneNumberException{
        if(phone.length()!=10)throw new InvalidPhoneNumberException("Invalid Phone Number");
        for(int i=0;i<phone.length();i++){
            if(!Character.isDigit(phone.charAt(i)))
                throw new InvalidPhoneNumberException("Invalid Phone Number");
        }
        for(Contact c:contacts){
            if(c.phone.equals(phone)){
                System.out.println("Duplicate Contact");
                return;
            }
        }
        contacts.add(new Contact(name,phone));
        System.out.println("Contact Added");
    }
    static void deleteContact(String phone){
        contacts.removeIf(c->c.phone.equals(phone));
        System.out.println("Contact Deleted");
    }

    static void searchContact(String phone){
        for(Contact c:contacts){
            if(c.phone.equals(phone)){
                System.out.println(c.name+" "+c.phone);
                return;
            }
        }
        System.out.println("Contact Not Found");
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Add 2.Delete 3.Search 4.Exit");
            int ch=sc.nextInt();
            try{
                if(ch==1){
                    System.out.print("Name:");
                    String name=sc.next();
                    System.out.print("Phone:");
                    String phone=sc.next();
                    addContact(name,phone);
                }
                else if(ch==2){
                    System.out.print("Phone:");
                    deleteContact(sc.next());
                }
                else if(ch==3){
                    System.out.print("Phone:");
                    searchContact(sc.next());
                }
                else break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
