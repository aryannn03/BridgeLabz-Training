package addressbook.service;

import addressbook.dao.AddressBookDAO;
import addressbook.model.Contact;
import java.util.*;

public class AddressBookService{
    private AddressBookDAO dao=new AddressBookDAO();

    public void createAddressBook(String name){
        dao.createBook(name);
    }

    public boolean addContact(String book,Contact c){
        if(dao.isDuplicate(book,c))return false;
        dao.addContact(book,c);
        return true;
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

    public List<Contact> searchPerson(String value){
        return dao.searchByCityOrState(value);
    }

    public Map<String,List<Contact>> viewByCity(){
        return dao.groupByCity();
    }

    public Map<String,List<Contact>> viewByState(){
        return dao.groupByState();
    }

    public Map<String,Long> countByCity(){
        return dao.countByCity();
    }

    public Map<String,Long> countByState(){
        return dao.countByState();
    }
}
