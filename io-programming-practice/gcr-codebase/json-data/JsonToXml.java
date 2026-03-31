import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class JsonToXml{
    public static void main(String[]args)throws Exception{
        ObjectMapper jsonMapper=new ObjectMapper();
        XmlMapper xmlMapper=new XmlMapper();

        JsonNode jsonNode=jsonMapper.readTree(
            new File("io-programming-practice/gcr-codebase/json-data/user.json")
        );

        String xml=xmlMapper.writeValueAsString(jsonNode);
        System.out.println(xml);
    }
}
