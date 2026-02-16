package io;

import model.Contact;
import java.net.*;
import java.io.*;

public class JSONServerClient {

    // UC16
    public static void send(Contact c)throws Exception{
        URL url=new URL("http://localhost:3000/contacts");
        HttpURLConnection con=(HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream os=con.getOutputStream();
        os.write(c.toString().getBytes());
        os.close();
        con.getResponseCode();
    }
}