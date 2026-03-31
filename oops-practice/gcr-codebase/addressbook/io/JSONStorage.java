package io;

import model.Contact;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.util.List;

public class JSONStorage {

    // UC15
    public static void writeJSON(List<Contact> list,String file)throws Exception{
        Gson gson=new Gson();
        FileWriter writer=new FileWriter(file);
        gson.toJson(list,writer);
        writer.close();
    }
}