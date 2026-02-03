import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import com.fasterxml.jackson.dataformat.csv.*;
import java.io.*;
import java.util.*;

public class IplCensorAnalyzer{
    public static void main(String[]args)throws Exception{
        ObjectMapper jsonMapper=new ObjectMapper();
        CsvMapper csvMapper=new CsvMapper();

        File jsonInput=new File("io-programming-practice/gcr-codebase/json-data/ipl.json");
        File csvInput=new File("io-programming-practice/gcr-codebase/json-data/ipl.csv");

        File jsonOutput=new File("io-programming-practice/gcr-codebase/json-data/ipl_censored.json");
        File csvOutput=new File("io-programming-practice/gcr-codebase/json-data/ipl_censored.csv");

        ArrayNode matches=(ArrayNode)jsonMapper.readTree(jsonInput);
        ArrayNode censoredJson=jsonMapper.createArrayNode();

        for(JsonNode m:matches){
            ObjectNode o=m.deepCopy();
            o.put("team1",mask(o.get("team1").asText()));
            o.put("team2",mask(o.get("team2").asText()));
            o.put("winner",mask(o.get("winner").asText()));
            o.put("player_of_match","REDACTED");
            censoredJson.add(o);
        }

        jsonMapper.writerWithDefaultPrettyPrinter()
                .writeValue(jsonOutput,censoredJson);

        CsvSchema schema=CsvSchema.builder()
                .addColumn("match_id")
                .addColumn("team1")
                .addColumn("team2")
                .addColumn("score_team1")
                .addColumn("score_team2")
                .addColumn("winner")
                .addColumn("player_of_match")
                .setUseHeader(true)
                .build();

        MappingIterator<Map<String,String>> it=
                csvMapper.readerFor(Map.class)
                .with(schema)
                .readValues(csvInput);

        List<Map<String,String>> rows=new ArrayList<>();

        while(it.hasNext()){
            Map<String,String> r=it.next();
            r.put("team1",mask(r.get("team1")));
            r.put("team2",mask(r.get("team2")));
            r.put("winner",mask(r.get("winner")));
            r.put("player_of_match","REDACTED");
            rows.add(r);
        }

        csvMapper.writer(schema).writeValue(csvOutput,rows);
    }

    static String mask(String s){
        int i=s.indexOf(" ");
        return i==-1?s:s.substring(0,i)+" ***";
    }
}
