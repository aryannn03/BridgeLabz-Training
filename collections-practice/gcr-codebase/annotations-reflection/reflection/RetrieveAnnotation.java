import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author{
    String name();
}

@Author(name="Author Name")
class Book{
}

public class RetrieveAnnotation{
    public static void main(String[] args){
        Class<Book> cls=Book.class;
        if(cls.isAnnotationPresent(Author.class)){
            Author a=cls.getAnnotation(Author.class);
            System.out.println(a.name());
        }
    }
}
