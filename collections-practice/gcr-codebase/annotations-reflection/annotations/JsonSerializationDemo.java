import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField{
    String name();
}
class User{
    @JsonField(name="user_name")
    String username;
    @JsonField(name="user_age")
    int age;
    User(String username,int age){
        this.username=username;
        this.age=age;
    }
}
public class JsonSerializationDemo{
    static String toJson(Object obj)throws Exception{
        StringBuilder sb=new StringBuilder("{");
        Field[] fields=obj.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            Field f=fields[i];
            if(f.isAnnotationPresent(JsonField.class)){
                JsonField j=f.getAnnotation(JsonField.class);
                f.setAccessible(true);
                sb.append("\"").append(j.name()).append("\":");
                Object val=f.get(obj);
                if(val instanceof String)
                    sb.append("\"").append(val).append("\"");
                else
                    sb.append(val);
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
    public static void main(String[] args)throws Exception{
        User u=new User("Aryan",21);
        System.out.println(toJson(u));
    }
}
