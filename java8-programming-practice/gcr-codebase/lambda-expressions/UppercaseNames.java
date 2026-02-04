import java.util.*;

public class UppercaseNames{
    public static void main(String[] args){
        List<String> names=List.of("parth","rahul","neha","simran");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
