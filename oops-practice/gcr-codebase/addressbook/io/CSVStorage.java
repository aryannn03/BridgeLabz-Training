package io;

import model.Contact;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.util.List;

public class CSVStorage {

    // UC14
    public static void writeCSV(List<Contact> list,String file)throws Exception{
        CSVWriter writer=new CSVWriter(new FileWriter(file));

        for(Contact c:list){
            String[] data={
                c.getFirstName(),
                c.getLastName(),
                c.getCity(),
                c.getState()
            };
            writer.writeNext(data);
        }
        writer.close();
    }
}