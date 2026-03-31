public class UserRegistration{
    public boolean registerUser(String username,String email,String password){
        if(username==null||username.isEmpty()){
            throw new IllegalArgumentException("Invalid username");
        }
        if(email==null||!email.contains("@")){
            throw new IllegalArgumentException("Invalid email");
        }
        if(password==null||password.length()<8){
            throw new IllegalArgumentException("Invalid password");
        }
        return true;
    }
    public static void main(String[]args){
        UserRegistration u=new UserRegistration();
        System.out.println(u.registerUser("john","john@gmail.com","Password1"));
    }
}
