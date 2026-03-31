import java.util.*;

public class PatientPrinter{
    public static void main(String[] args){
        List<String> patientIds=List.of("P101","P102","P103","P104");
        patientIds.forEach(System.out::println);
    }
}
