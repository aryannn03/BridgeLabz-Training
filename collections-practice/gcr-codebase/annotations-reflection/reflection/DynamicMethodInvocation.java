import java.lang.reflect.*;
import java.util.*;

class MathOperations{
    public int add(int a,int b){
        return a+b;
    }
    public int subtract(int a,int b){
        return a-b;
    }
    public int multiply(int a,int b){
        return a*b;
    }
}

public class DynamicMethodInvocation{
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        String methodName=sc.nextLine();
        int a=sc.nextInt();
        int b=sc.nextInt();
        MathOperations obj=new MathOperations();
        Method method=MathOperations.class.getDeclaredMethod(methodName,int.class,int.class);
        Object result=method.invoke(obj,a,b);
        System.out.println(result);
    }
}
