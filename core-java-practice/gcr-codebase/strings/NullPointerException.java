public class NullPointerException{
    public static void generateException(){
        String text=null;
        text.length();
    }
    public static void handleException(){
        String text=null;
        try{
            text.length();
        }catch(NullPointerException exception){
            System.out.println("NullPointerException handled");
        }
    }
    public static void main(String[]args){
        try{
            generateException();
        }catch(Exception e){
        }
        handleException();
    }
}
