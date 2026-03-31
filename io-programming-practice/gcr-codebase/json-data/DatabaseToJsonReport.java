import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseToJsonReport {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode reportArray = mapper.createArrayNode();

        while (rs.next()) {
            ObjectNode obj = mapper.createObjectNode();
            obj.put("id", rs.getInt("id"));
            obj.put("name", rs.getString("name"));
            obj.put("email", rs.getString("email"));
            obj.put("age", rs.getInt("age"));

            reportArray.add(obj);
        }

        rs.close();
        stmt.close();
        con.close();

        System.out.println(
            mapper.writerWithDefaultPrettyPrinter().writeValueAsString(reportArray)
        );
    }
}
