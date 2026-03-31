import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult{}

class ExpensiveService{
    @CacheResult
    int compute(int n){
        int sum=0;
        for(int i=0;i<=n;i++)
            sum+=i;
        return sum;
    }
}

public class CacheResultDemo{
    static Map<String,Object> cache=new HashMap<>();
    static Object invokeWithCache(Object obj,String methodName,Object... args)throws Exception{
        Method m=obj.getClass().getDeclaredMethod(methodName,int.class);
        String key=methodName+Arrays.toString(args);
        if(m.isAnnotationPresent(CacheResult.class)){
            if(cache.containsKey(key))
                return cache.get(key);
            Object result=m.invoke(obj,args);
            cache.put(key,result);
            return result;
        }
        return m.invoke(obj,args);
    }
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ExpensiveService s=new ExpensiveService();
        System.out.println(invokeWithCache(s,"compute",n));
        System.out.println(invokeWithCache(s,"compute",n));
    }
}
