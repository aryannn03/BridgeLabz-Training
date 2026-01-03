class Animal {
    String name;
    int age;

    Animal(String n,int a){
        name=n;
        age=a;
    }

    void makeSound(){
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    Dog(String n,int a){
        super(n,a);
    }

    void makeSound(){
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    Cat(String n,int a){
        super(n,a);
    }

    void makeSound(){
        System.out.println("Cat meows");
    }
}

class Bird extends Animal {
    Bird(String n,int a){
        super(n,a);
    }

    void makeSound(){
        System.out.println("Bird chirps");
    }
}

public class Main {
    public static void main(String[] args){
        Animal[] a={
            new Dog("Tommy",3),
            new Cat("Kitty",2),
            new Bird("Parrot",1)
        };

        for(Animal x:a)
            x.makeSound();   
    }
}
