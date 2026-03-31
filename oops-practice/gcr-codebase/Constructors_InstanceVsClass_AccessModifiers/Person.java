public class Person{
    String name;
    int age;

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public Person(Person p){
        name=p.name;
        age=p.age;
    }

    void display(){
        System.out.println(name+" "+age);
    }

    public static void main(String[]args){
        Person p1=new Person("Aryan",20);
        Person p2=new Person(p1);
        p2.display();
    }
}
