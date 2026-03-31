import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}
class Project{
    @Todo(task="Implement login",assignedTo="Amit",priority="HIGH")
    void login(){}
    @Todo(task="Add logout feature",assignedTo="Neha")
    void logout(){}
    @Todo(task="Optimize database",assignedTo="Ravi",priority="LOW")
    void optimize(){}
}
public class TodoDemo{
    public static void main(String[] args){
        Method[] methods=Project.class.getDeclaredMethods();
        for(Method m:methods){
            if(m.isAnnotationPresent(Todo.class)){
                Todo t=m.getAnnotation(Todo.class);
                System.out.println(m.getName()+" "+t.task()+" "+t.assignedTo()+" "+t.priority());
            }
        }
    }
}
