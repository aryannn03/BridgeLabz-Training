import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
    String level() default "HIGH";
}
class Service{
    @ImportantMethod
    void start(){
        System.out.println("Service started");
    }
    @ImportantMethod(level="LOW")
    void stop(){
        System.out.println("Service stopped");
    }
    void idle(){
        System.out.println("Idle");
    }
}
public class ImportantMethodDemo{
    public static void main(String[] args){
        Method[] methods=Service.class.getDeclaredMethods();
        for(Method m:methods){
            if(m.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod im=m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName()+" "+im.level());
            }
        }
    }
}
