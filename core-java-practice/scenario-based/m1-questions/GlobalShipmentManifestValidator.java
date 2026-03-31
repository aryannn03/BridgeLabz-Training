import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GlobalShipmentManifestValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        while(n-->0){
            String s=sc.nextLine();
            System.out.println(validate(s));
        }
    }
    public static String validate(String record){
        try{
            String arr[]=record.split("\\|");
            if(arr.length != 5) return "NON-COMPLIANT RECORD";
            if(code(arr[0]) && date(arr[1]) && mode(arr[2]) && isValid(arr[3]) && status(arr[4])){
                return "COMPLIANT RECORD";
            }
            else{
                return "NON-COMPLIANT RECORD";
            }
        }
        catch(Exception e){
            return "NON-COMPLIANT RECORD";
        }

    }
    public static boolean code(String c){
        String pat="^SHIP-(?!.*(\\d)(\\1){3,})[1-9][0-9]{5}$";
        return c.matches(pat);
    }
    public static boolean date(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate d=LocalDate.parse(date,formatter);
            int year=d.getYear();
            return (year>=2000 && year<=2099);
        }
        catch(DateTimeParseException e){
            return false;
        }
    }
    public static boolean mode(String mode){
        return mode.equals("AIR") || mode.equals("SEA") || mode.equals("ROAD") || mode.equals("RAIL") || mode.equals("EXPRESS") || mode.equals("FREIGHT") ;
    }
    public static boolean isValid(String value) {
        double v= Double.parseDouble(value);
        return value.matches("^(0|[1-9]\\d{0,5})(\\.\\d{1,2})?$") && v<=999999.99;
    }
    public static boolean status(String status){
        return status.equals("DELIVERED") || status.equals("CANCELLED") || status.equals("IN_TRANSIT");
    }
}