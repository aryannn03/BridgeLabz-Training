import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime{}

class Calculator{
    @LogExecutionTime
    void fastTask(){
        for(int i=0;i<100000;i++){}
    }
    @LogExecutionTime
    void slowTask(){
        for(int i=0;i<10000000;i++){}
    }
}
public class LogExecutionTimeDemo{
    public static void main(String[] args)throws Exception{
        Calculator c=new Calculator();
        Method[] methods=Calculator.class.getDeclaredMethods();
        for(Method m:methods){
            if(m.isAnnotationPresent(LogExecutionTime.class)){
                long start=System.nanoTime();
                m.invoke(c);
                long end=System.nanoTime();
                System.out.println(m.getName()+" "+(end-start));
            }
        }
    }
}
