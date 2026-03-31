import java.lang.reflect.*;

class TaskRunner{
    void quickTask(){
        for(int i=0;i<100000;i++){}
    }
    void slowTask(){
        for(int i=0;i<10000000;i++){}
    }
}

public class MethodExecutionTiming{
    public static void main(String[] args)throws Exception{
        TaskRunner runner=new TaskRunner();
        Method[] methods=TaskRunner.class.getDeclaredMethods();
        for(Method method:methods){
            long start=System.nanoTime();
            method.invoke(runner);
            long end=System.nanoTime();
            System.out.println(method.getName()+" "+(end-start));
        }
    }
}
