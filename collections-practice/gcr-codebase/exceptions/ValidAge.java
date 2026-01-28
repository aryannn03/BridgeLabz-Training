import java.util.*;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class ValidAge {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        try {
            System.out.print("Enter age:");
            int age=ob.nextInt();
            validateAge(age);
            System.out.println("Access granted!");
        } catch(InvalidAgeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Validation completed");
        }
    }
    public static void validateAge(int age)throws InvalidAgeException {
        if(age<18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }
}