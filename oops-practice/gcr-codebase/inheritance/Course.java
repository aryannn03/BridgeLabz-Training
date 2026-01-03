class Course {
    String name;
    int dur;

    Course(String n,int d){
        name=n;
        dur=d;
    }
}

class OnlineCourse extends Course {
    String plat;
    boolean rec;

    OnlineCourse(String n,int d,String p,boolean r){
        super(n,d);
        plat=p;
        rec=r;
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee,disc;

    PaidOnlineCourse(String n,int d,String p,boolean r,double f,double dc){
        super(n,d,p,r);
        fee=f;
        disc=dc;
    }

    void show(){
        System.out.println(name+" Fee: "+(fee-disc));
    }
}

public class Main {
    public static void main(String[] args){
        PaidOnlineCourse c=new PaidOnlineCourse("DSA",60,"Udemy",true,5000,1000);
        c.show();
    }
}
