import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed{
    String value();
}
class AdminService{
    @RoleAllowed("ADMIN")
    void deleteUser(){
        System.out.println("User deleted");
    }
}
public class RoleBasedAccessDemo{
    static String currentRole="USER";
    public static void main(String[] args)throws Exception{
        AdminService service=new AdminService();
        Method m=AdminService.class.getDeclaredMethod("deleteUser");
        RoleAllowed r=m.getAnnotation(RoleAllowed.class);
        if(r!=null&&r.value().equals(currentRole))
            m.invoke(service);
        else
            System.out.println("Access Denied!");
    }
}
