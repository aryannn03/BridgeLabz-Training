import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class MergeJsonFiles{
    public static void main(String[]args)throws Exception{
        ObjectMapper mapper=new ObjectMapper();

        JsonNode json1=mapper.readTree(new File("io-programming-practice/gcr-codebase/json-data/user.json"));
        JsonNode json2=mapper.readTree(new File("io-programming-practice/gcr-codebase/json-data/email-schema.json"));

        ObjectNode merged=mapper.createObjectNode();
        merged.setAll((ObjectNode)json1);
        merged.setAll((ObjectNode)json2);

        System.out.println(merged.toString());
    }
}
