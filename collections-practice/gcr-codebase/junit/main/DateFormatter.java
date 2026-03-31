import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter{
    public String formatDate(String inputDate){
        DateTimeFormatter in=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter out=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date=LocalDate.parse(inputDate,in);
        return date.format(out);
    }
    public static void main(String[]args){
        DateFormatter d=new DateFormatter();
        System.out.println(d.formatDate("2024-01-15"));
    }
}
