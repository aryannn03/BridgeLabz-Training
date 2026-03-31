import java.lang.reflect.*;
import java.util.*;

public class ClassInspector{
    public static void main(String[] args)throws Exception{
        Scanner scanner=new Scanner(System.in);
        String classToInspect=scanner.nextLine();
        Class<?> inspectedClass=Class.forName(classToInspect);

        Method[] declaredMethods=inspectedClass.getDeclaredMethods();
        Field[] declaredFields=inspectedClass.getDeclaredFields();
        Constructor<?>[] declaredConstructors=inspectedClass.getDeclaredConstructors();

        for(Method method:declaredMethods)
            System.out.println("Method "+method.getName());

        for(Field field:declaredFields)
            System.out.println("Field "+field.getName());

        for(Constructor<?> constructor:declaredConstructors)
            System.out.println("Constructor "+constructor.getName());
    }
}
