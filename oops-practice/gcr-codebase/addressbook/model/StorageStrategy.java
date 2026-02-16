package model;

import java.util.List;

// UC18
public interface StorageStrategy{
    void save(List<Contact> list)throws Exception;
}