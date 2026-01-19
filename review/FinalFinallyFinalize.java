public class FinalFinallyFinalize {
    public static void main(String[] args) {
        finalExample();
        finallyExample();    
        finalizeExample();
    }
    public static void finalExample(){
        final int x=10;
        // x=50; 
    }
    public static void finallyExample(){
        try{
            int a=10/0;
        }
        catch(ArithmeticException e){
            System.out.println("Exception caught");
        }
        finally{
            System.out.println("This block is always executed");
        }
    }
    public static void finalizeExample(){
        FinalFinallyFinalize obj=new FinalFinallyFinalize();
        obj=null;
        System.gc();
    }
}
final class parent{
    final void show(){
        System.out.println("Parent class method");
    }
}
// class child extends parent{
//     void show(){ 
//         System.out.println("Child class method");
//     }
// }
