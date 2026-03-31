import java.io.*;

public class CSVRowCounter {
    public static void main(String[] args) {
        String filePath = "io-programming-practice/gcr-codebase/csv-data-handling/employees.csv";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
