import java.io.*;
import org.json.*;

public class JSONCSVConverter {

    static String basePath = "io-programming-practice/gcr-codebase/csv-data-handling/";

    public static void main(String[] args) throws Exception {
        jsonToCsv();
        csvToJson();
    }

    static void jsonToCsv() throws Exception {

        BufferedReader br = new BufferedReader(
                new FileReader(basePath + "students.json"));
        StringBuilder jsonData = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            jsonData.append(line);
        }
        br.close();

        JSONArray arr = new JSONArray(jsonData.toString());
        BufferedWriter bw = new BufferedWriter(
                new FileWriter(basePath + "students.csv"));

        bw.write("ID,Name,Age,Marks");
        bw.newLine();

        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            bw.write(
                obj.getInt("id") + "," +
                obj.getString("name") + "," +
                obj.getInt("age") + "," +
                obj.getInt("marks")
            );
            bw.newLine();
        }
        bw.close();

        System.out.println("JSON to CSV completed");
    }

    static void csvToJson() throws Exception {

        BufferedReader br = new BufferedReader(
                new FileReader(basePath + "students.csv"));

        JSONArray arr = new JSONArray();
        String line = br.readLine();

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            JSONObject obj = new JSONObject();
            obj.put("id", Integer.parseInt(data[0]));
            obj.put("name", data[1]);
            obj.put("age", Integer.parseInt(data[2]));
            obj.put("marks", Integer.parseInt(data[3]));

            arr.put(obj);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(
                new FileWriter(basePath + "students_converted.json"));
        bw.write(arr.toString(4));
        bw.close();

        System.out.println("CSV to JSON completed");
    }
}
