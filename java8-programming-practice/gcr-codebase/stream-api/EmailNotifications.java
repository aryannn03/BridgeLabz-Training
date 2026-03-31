import java.util.*;

public class EmailNotifications{
    static void sendEmailNotification(String email){
        System.out.println("Notification sent to "+email);
    }
    public static void main(String[] args){
        List<String> emails=Arrays.asList(
            "user1@mail.com",
            "user2@mail.com",
            "user3@mail.com"
        );
        emails.forEach(email->sendEmailNotification(email));
    }
}
