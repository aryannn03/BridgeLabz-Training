import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
    int priority();
    String assignedTo();
}
class TaskManager{
    @TaskInfo(priority=1,assignedTo="Aryan")
    void completeTask(){
        System.out.println("Task completed");
    }
}
public class CustomAnnotationDemo{
    public static void main(String[] args)throws Exception{
        TaskManager tm=new TaskManager();
        Method m=tm.getClass().getDeclaredMethod("completeTask");
        TaskInfo t=m.getAnnotation(TaskInfo.class);
        System.out.println(t.priority());
        System.out.println(t.assignedTo());
        tm.completeTask();
    }
}
