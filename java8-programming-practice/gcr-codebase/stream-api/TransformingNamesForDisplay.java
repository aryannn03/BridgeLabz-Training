import java.util.*;
import java.util.stream.*;

public class TransformingNamesForDisplay{
    public static void main(String[] args){
        List<String> customerNames=Arrays.asList(
            "Aryan",
            "Neha",
            "Kunal",
            "Aman",
            "Riya"
        );

        customerNames.stream()
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
    }
}
