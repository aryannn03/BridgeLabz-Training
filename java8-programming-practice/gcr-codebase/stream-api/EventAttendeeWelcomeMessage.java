import java.util.*;
import java.util.stream.*;

public class EventAttendeeWelcomeMessage{
    public static void main(String[] args){
        List<String> attendees=Arrays.asList(
            "Aryan",
            "Neha",
            "Kunal",
            "Riya"
        );

        attendees.stream()
            .forEach(name->System.out.println("Welcome "+name));
    }
}
