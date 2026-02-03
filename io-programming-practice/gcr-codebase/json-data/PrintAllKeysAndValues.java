import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class PrintAllKeysAndValues{
    public static void main(String[]args)throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        JsonNode root=mapper.readTree(new File("io-programming-practice/gcr-codebase/json-data/user.json"));
        printNode(root);
    }

    static void printNode(JsonNode node){
        if(node.isObject()){
            Iterator<Map.Entry<String,JsonNode>> fields=node.fields();
            while(fields.hasNext()){
                Map.Entry<String,JsonNode> entry=fields.next();
                System.out.println(entry.getKey()+" : "+entry.getValue());
                printNode(entry.getValue());
            }
        }else if(node.isArray()){
            for(JsonNode n:node)
                printNode(n);
        }
    }
}
