import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject{}

class Engine{
    void start(){
        System.out.println("Engine started");
    }
}

class Car{
    @Inject
    Engine engine;
    void drive(){
        engine.start();
        System.out.println("Car driving");
    }
}

public class DependencyInjection{
    static void injectDependencies(Object obj)throws Exception{
        Field[] fields=obj.getClass().getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(Inject.class)){
                Object dependency=field.getType().getDeclaredConstructor().newInstance();
                field.setAccessible(true);
                field.set(obj,dependency);
            }
        }
    }
    public static void main(String[] args)throws Exception{
        Car car=new Car();
        injectDependencies(car);
        car.drive();
    }
}
