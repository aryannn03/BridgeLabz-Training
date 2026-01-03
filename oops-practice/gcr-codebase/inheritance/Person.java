class Person {
    String name;
    int age;

    Person(String n,int a){
        name=n;
        age=a;
    }
}

class Teacher extends Person {
    String sub;

    Teacher(String n,int a,String s){
        super(n,a);
        sub=s;
    }

    void displayRole(){
        System.out.println("Teacher");
    }
}

class Student extends Person {
    int grade;

    Student(String n,int a,int g){
        super(n,a);
        grade=g;
    }

    void displayRole(){
        System.out.println("Student");
    }
}

class Staff extends Person {
    String dept;

    Staff(String n,int a,String d){
        super(n,a);
        dept=d;
    }

    void displayRole(){
        System.out.println("Staff");
    }
}
