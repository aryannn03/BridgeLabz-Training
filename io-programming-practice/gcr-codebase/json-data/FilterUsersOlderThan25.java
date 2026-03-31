import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FilterUsersOlderThan25{
    public static void main(String[]args)throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        JsonNode root=mapper.readTree(new File("io-programming-practice/gcr-codebase/json-data/user.json"));

        if(root.isArray()){
            for(JsonNode user:root){
                if(user.has("age")&&user.get("age").asInt()>25)
                    System.out.println(user.toString());
            }
        }else{
            if(root.has("age")&&root.get("age").asInt()>25)
                System.out.println(root.toString());
        }
    }
}
