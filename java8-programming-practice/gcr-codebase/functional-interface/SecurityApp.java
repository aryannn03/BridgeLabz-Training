interface Sensitive{
}

class UserData implements Sensitive{
    String username;
    String password;
    UserData(String u,String p){
        username=u;
        password=p;
    }
    String maskPassword(){
        StringBuilder masked=new StringBuilder();
        for(int i=0;i<password.length();i++){
            masked.append("*");
        }
        return masked.toString();
    }
    void display(){
        System.out.println("Username:"+username);
        if(this instanceof Sensitive){
            System.out.println("Password:"+maskPassword());
        }else{
            System.out.println("Password:"+password);
        }
    }
}

public class SecurityApp{
    public static void main(String[] args){
        UserData user=new UserData("admin","secure123");
        if(user instanceof Sensitive){
            System.out.println("Sensitive data detected. Applying masking...");
        }
        user.display();
    }
}
