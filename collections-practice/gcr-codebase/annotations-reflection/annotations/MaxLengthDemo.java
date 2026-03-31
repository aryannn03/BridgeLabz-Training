import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
    int value();
}
class User{
    @MaxLength(10)
    String username;
    User(String username){
        try{
            Field f=this.getClass().getDeclaredField("username");
            MaxLength m=f.getAnnotation(MaxLength.class);
            if(m!=null&&username.length()>m.value())
                throw new IllegalArgumentException();
            this.username=username;
            System.out.println(this.username);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }
}
public class MaxLengthDemo{
    public static void main(String[] args){
        new User("Aryan");
        new User("VeryLongUsername");
    }
}
