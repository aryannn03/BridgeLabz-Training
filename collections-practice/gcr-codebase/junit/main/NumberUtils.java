public class NumberUtils{
    public boolean isEven(int number){
        return number%2==0;
    }
    public static void main(String[]args){
        NumberUtils n=new NumberUtils();
        System.out.println(n.isEven(2));
        System.out.println(n.isEven(7));
    }
}
