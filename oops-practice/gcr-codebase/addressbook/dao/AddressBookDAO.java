package addressbook.dao;

import addressbook.model.Contact;
import java.util.*;

public class AddressBookDAO{
    private Map<String,List<Contact>> books=new HashMap<>();

    public void createBook(String name){
        books.putIfAbsent(name,new ArrayList<>());
    }

    public void addContact(String book,Contact c){
        books.get(book).add(c);
    }

    public List<Contact> getContacts(String book){
        return books.get(book);
    }

    public void deleteContact(String book,String firstName){
        books.get(book).removeIf(c->c.getFirstName().equals(firstName));
    }

    public void updateContact(String book,String firstName,Contact c){
        List<Contact> list=books.get(book);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getFirstName().equals(firstName)){
                list.set(i,c);
                break;
            }
        }
    }

    public Set<String> getBookNames(){
        return books.keySet();
    }
}
