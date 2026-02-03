import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FilterUsersByAge{
    public static void main(String[]args)throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        JsonNode root=mapper.readTree(new File("io-programming-practice/gcr-codebase/json-data/user.json"));
        int age=root.get("age").asInt();
        if(age>25)
            System.out.println(root.toString());
    }
}

