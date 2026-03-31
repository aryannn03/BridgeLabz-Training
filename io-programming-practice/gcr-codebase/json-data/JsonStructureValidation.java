import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonStructureValidation{
    public static void main(String[]args)throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        JsonNode root=mapper.readTree(new File("io-programming-practice/gcr-codebase/json-data/user.json"));

        boolean valid=true;

        if(root.get("name")==null)valid=false;
        if(root.get("email")==null)valid=false;
        if(root.get("age")==null)valid=false;

        if(valid)
            System.out.println("Valid JSON Structure");
        else
            System.out.println("Invalid JSON Structure");
    }
}
