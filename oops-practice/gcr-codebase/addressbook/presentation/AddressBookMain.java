package addressbook.presentation;

import addressbook.service.AddressBookService;
import addressbook.model.Contact;
import java.util.*;

public class AddressBookMain{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        AddressBookService service=new AddressBookService();
        String currentBook="default";
        service.createAddressBook(currentBook);

        while(true){
            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete Contact");
            System.out.println("4.Show Contacts");
            System.out.println("5.New Address Book");
            System.out.println("6.Switch Address Book");
            System.out.println("0.Exit");
            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==0)break;

            if(choice==1){
                service.addContact(currentBook,inputContact(sc));
            }

            if(choice==2){
                System.out.print("First Name:");
                String fn=sc.nextLine();
                service.editContact(currentBook,fn,inputContact(sc));
            }

            if(choice==3){
                System.out.print("First Name:");
                service.deleteContact(currentBook,sc.nextLine());
            }

            if(choice==4){
                for(Contact c:service.getContacts(currentBook))
                    System.out.println(c);
            }

            if(choice==5){
                System.out.print("Book Name:");
                service.createAddressBook(sc.nextLine());
            }

            if(choice==6){
                System.out.println(service.getBooks());
                currentBook=sc.nextLine();
            }
        }
    }

    static Contact inputContact(Scanner sc){
        String fn=sc.nextLine();
        String ln=sc.nextLine();
        String ad=sc.nextLine();
        String ct=sc.nextLine();
        String st=sc.nextLine();
        String zp=sc.nextLine();
        String ph=sc.nextLine();
        String em=sc.nextLine();
        return new Contact(fn,ln,ad,ct,st,zp,ph,em);
    }
}
