package addressbook.service;

import addressbook.dao.AddressBookDAO;
import addressbook.model.Contact;
import java.util.*;

public class AddressBookService{
    private AddressBookDAO dao=new AddressBookDAO();

    public void createAddressBook(String name){
        dao.createBook(name);
    }

    public void addContact(String book,Contact c){
        dao.addContact(book,c);
    }

    public void editContact(String book,String firstName,Contact c){
        dao.updateContact(book,firstName,c);
    }

    public void deleteContact(String book,String firstName){
        dao.deleteContact(book,firstName);
    }

    public List<Contact> getContacts(String book){
        return dao.getContacts(book);
    }

    public Set<String> getBooks(){
        return dao.getBookNames();
    }
}
