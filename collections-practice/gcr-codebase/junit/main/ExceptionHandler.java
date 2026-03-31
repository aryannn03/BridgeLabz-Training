public class ExceptionHandler{
    public int divide(int a,int b){
        if(b==0){
            throw new ArithmeticException("Division by zero");
        }
        return a/b;
    }
    public static void main(String[]args){
        ExceptionHandler e=new ExceptionHandler();
        System.out.println(e.divide(10,2));
    }
}
