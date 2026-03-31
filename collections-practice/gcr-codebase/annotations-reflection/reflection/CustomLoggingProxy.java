import java.lang.reflect.*;

interface Greeting{
    void sayHello();
}

class GreetingImpl implements Greeting{
    public void sayHello(){
        System.out.println("Hello");
    }
}

class LoggingHandler implements InvocationHandler{
    Object target;
    LoggingHandler(Object target){
        this.target=target;
    }
    public Object invoke(Object proxy,Method method,Object[] args)throws Throwable{
        System.out.println(method.getName());
        return method.invoke(target,args);
    }
}

public class CustomLoggingProxy{
    public static void main(String[] args){
        Greeting greeting=new GreetingImpl();
        Greeting proxy=(Greeting)Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            new LoggingHandler(greeting)
        );
        proxy.sayHello();
    }
}
