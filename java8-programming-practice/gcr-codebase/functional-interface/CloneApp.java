class Prototype implements Cloneable{
    int value=10;
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class CloneApp{
    public static void main(String[] args) throws Exception{
        Prototype p1=new Prototype();
        Prototype p2=(Prototype)p1.clone();
        System.out.println("Original:"+p1.value);
        System.out.println("Clone:"+p2.value);
    }
}
