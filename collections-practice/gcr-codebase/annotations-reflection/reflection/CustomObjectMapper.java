import java.lang.reflect.*;
import java.util.*;

class User{
    String name;
    int age;
}

public class CustomObjectMapper{
    static <T> T toObject(Class<T> clazz,Map<String,Object> properties)throws Exception{
        T obj=clazz.getDeclaredConstructor().newInstance();
        for(Map.Entry<String,Object> entry:properties.entrySet()){
            Field field=clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj,entry.getValue());
        }
        return obj;
    }
    public static void main(String[] args)throws Exception{
        Map<String,Object> properties=new HashMap<>();
        properties.put("name","Aryan");
        properties.put("age",21);
        User user=toObject(User.class,properties);
        System.out.println(user.name);
        System.out.println(user.age);
    }
}
