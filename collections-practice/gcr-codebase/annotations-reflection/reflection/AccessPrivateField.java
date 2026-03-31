import java.lang.reflect.*;

class Person{
    private int age;
    Person(int age){
        this.age=age;
    }
}

public class AccessPrivateField{
    public static void main(String[] args)throws Exception{
        Person person=new Person(21);
        Field ageField=Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(person,30);
        System.out.println(ageField.getInt(person));
    }
}
