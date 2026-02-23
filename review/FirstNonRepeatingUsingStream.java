import java.util.*;
import java.util.stream.*;

class FirstNonRepeatingUsingStream{
    public static void main(String[] args) {
        String s="swiss";
        List<Character> lst = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Optional<Character> op=lst.stream().filter(c -> Collections.frequency(lst, c) == 1).findFirst();
        System.out.println(op.orElse(null));
    }
}