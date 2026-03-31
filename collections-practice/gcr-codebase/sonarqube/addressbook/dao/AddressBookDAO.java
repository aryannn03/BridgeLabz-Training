package addressbook.dao;

import addressbook.model.Contact;
import java.util.*;

public class AddressBookDAO{
    private Map<String,List<Contact>> books=new HashMap<>();

    public void createBook(String name){
        books.putIfAbsent(name,new ArrayList<>());
    }

    public boolean isDuplicate(String book,Contact c){
        return books.get(book).contains(c);
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

    public List<Contact> searchByCityOrState(String value){
        List<Contact> result=new ArrayList<>();
        for(List<Contact> list:books.values()){
            for(Contact c:list){
                if(c.getCity().equals(value)||c.getState().equals(value))
                    result.add(c);
            }
        }
        return result;
    }

    public Map<String,List<Contact>> groupByCity(){
        Map<String,List<Contact>> map=new HashMap<>();
        for(List<Contact> list:books.values()){
            for(Contact c:list){
                map.computeIfAbsent(c.getCity(),k->new ArrayList<>()).add(c);
            }
        }
        return map;
    }

    public Map<String,List<Contact>> groupByState(){
        Map<String,List<Contact>> map=new HashMap<>();
        for(List<Contact> list:books.values()){
            for(Contact c:list){
                map.computeIfAbsent(c.getState(),k->new ArrayList<>()).add(c);
            }
        }
        return map;
    }

    public Map<String,Long> countByCity(){
        Map<String,Long> map=new HashMap<>();
        for(List<Contact> list:books.values()){
            for(Contact c:list){
                map.put(c.getCity(),map.getOrDefault(c.getCity(),0L)+1);
            }
        }
        return map;
    }

    public Map<String,Long> countByState(){
        Map<String,Long> map=new HashMap<>();
        for(List<Contact> list:books.values()){
            for(Contact c:list){
                map.put(c.getState(),map.getOrDefault(c.getState(),0L)+1);
            }
        }
        return map;
    }
}
