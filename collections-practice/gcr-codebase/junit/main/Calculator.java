public class Calculator{
    public int add(int a,int b){
        return a+b;
    }
    public int subtract(int a,int b){
        return a-b;
    }
    public int multiply(int a,int b){
        return a*b;
    }
    public int divide(int a,int b){
        if(b==0){
            throw new ArithmeticException("Division by zero");
        }
        return a/b;
    }
    public static void main(String[]args){
        Calculator c=new Calculator();
        System.out.println(c.add(3,4));
        System.out.println(c.subtract(5,2));
        System.out.println(c.multiply(4,5));
        System.out.println(c.divide(10,2));
    }
}
