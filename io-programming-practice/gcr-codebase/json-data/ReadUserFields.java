import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadUserFields{
    public static void main(String[]args)throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        JsonNode root=mapper.readTree(new File("io-programming-practice/gcr-codebase/json-data/user.json"));
        String name=root.get("name").asText();
        String email=root.get("email").asText();
        System.out.println(name);
        System.out.println(email);
    }
}
