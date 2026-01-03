interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String n,int i){
        name=n;
        id=i;
    }
}

class Chef extends Person implements Worker {
    Chef(String n,int i){
        super(n,i);
    }

    public void performDuties(){
        System.out.println("Cooking food");
    }
}

class Waiter extends Person implements Worker {
    Waiter(String n,int i){
        super(n,i);
    }

    public void performDuties(){
        System.out.println("Serving customers");
    }
}
