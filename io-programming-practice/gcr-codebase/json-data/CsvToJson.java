import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.FileReader;

public class CsvToJson {
    public static void main(String[] args) throws Exception {

        String csvFile = "io-programming-practice/gcr-codebase/json-data/users.csv";

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();

        String headerLine = reader.readLine();
        String[] headers = headerLine.split(",");

        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            ObjectNode obj = mapper.createObjectNode();

            for (int i = 0; i < headers.length; i++) {
                obj.put(headers[i], values[i]);
            }
            jsonArray.add(obj);
        }

        reader.close();

        System.out.println(
            mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray)
        );
    }
}
