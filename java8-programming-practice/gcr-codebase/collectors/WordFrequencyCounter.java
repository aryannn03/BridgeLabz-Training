import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {

    public static void main(String[] args){

        String paragraph="java is easy and java is powerful and java is popular";

        Map<String,Integer> wordCount=
                Arrays.stream(paragraph.toLowerCase().split("\\s+"))
                        .collect(Collectors.toMap(
                                word->word,
                                word->1,
                                Integer::sum
                        ));

        wordCount.forEach((word,count)->{
            System.out.println(word+" -> "+count);
        });
    }
}
