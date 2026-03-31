import java.util.Scanner;

public class KeyGeneration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while(n-- > 0){

            String st = sc.nextLine();

            if(st.matches("^[a-zA-Z]{6,}$")){

                String key = generate(st);

                if(key.length()==0){
                    System.out.println("Invalid Input (empty string)");
                }
                else{
                    System.out.println("The generated key is - " + key);
                }

            }
            else{

                if(st.length()==0){
                    System.out.println("Invalid Input (empty string)");
                }
                else if(st.length()<6){
                    System.out.println("Invalid Input (length < 6)");
                }
                else if(st.contains(" ")){
                    System.out.println("Invalid Input (contains space)");
                }
                else if(st.matches(".*[0-9].*")){
                    System.out.println("Invalid Input (contains digits)");
                }
                else{
                    System.out.println("Invalid Input (contains special character)");
                }
            }
        }
    }

    public static String generate(String s){

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)%2==1){
                sb.append(s.charAt(i));
            }
        }

        sb.reverse();

        StringBuilder result = new StringBuilder();

        for(int i=0;i<sb.length();i++){

            if(i%2==0){
                result.append(Character.toUpperCase(sb.charAt(i)));
            }
            else{
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }
}