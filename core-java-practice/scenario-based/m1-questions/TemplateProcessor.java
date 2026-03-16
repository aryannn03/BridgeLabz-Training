import java.util.*;
import java.util.regex.*;
import java.time.*;
import java.time.format.*;

public class TemplateProcessor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Pattern p = Pattern.compile("\\$\\{(.*?)\\}");

        while(n-- > 0){

            String line = sc.nextLine();
            Matcher m = p.matcher(line);

            StringBuffer result = new StringBuffer();

            while(m.find()){

                String content = m.group(1);
                String replacement = process(content);

                m.appendReplacement(result, replacement);
            }

            m.appendTail(result);

            System.out.println(result.toString());
        }
    }

    static String process(String content){

        try{

            String[] parts = content.split(":",2);
            String type = parts[0];
            String value = parts[1];

            switch(type){

                case "UPPER":
                    return value.toUpperCase();

                case "LOWER":
                    return value.toLowerCase();

                case "REPEAT":

                    String[] v = value.split(",");
                    String word = v[0];
                    int count = Integer.parseInt(v[1]);

                    StringBuilder sb = new StringBuilder();

                    for(int i=0;i<count;i++)
                        sb.append(word);

                    return sb.toString();

                case "DATE":

                    DateTimeFormatter input =
                        DateTimeFormatter.ofPattern("dd-MM-yyyy");

                    LocalDate date = LocalDate.parse(value,input);

                    DateTimeFormatter output =
                        DateTimeFormatter.ofPattern("yyyy/MM/dd");

                    return date.format(output);

                default:
                    return "INVALID";
            }

        } catch(Exception e){
            return "INVALID";
        }
    }
}