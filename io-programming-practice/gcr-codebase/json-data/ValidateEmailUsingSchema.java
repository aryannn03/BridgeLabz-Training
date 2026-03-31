import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;

public class ValidateEmailUsingSchema{
    public static void main(String[]args)throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        JsonNode schemaNode=mapper.readTree(new File("io-programming-practice/gcr-codebase/json-data/email-schema.json"));
        JsonNode dataNode=mapper.readTree(new File("io-programming-practice/gcr-codebase/json-data/user.json"));
        JsonSchema schema=JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);
        if(schema.validate(dataNode).isSuccess())
            System.out.println("Valid Email");
        else
            System.out.println("Invalid Email");
    }
}
