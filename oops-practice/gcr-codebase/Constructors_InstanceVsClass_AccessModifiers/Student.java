public class Student{
    public int rollNumber;
    protected String name;
    private double cgpa;

    public void setCGPA(double cgpa){
        this.cgpa=cgpa;
    }

    public double getCGPA(){
        return cgpa;
    }

    public static void main(String[]args){
        Student s=new Student();
        s.rollNumber=1;
        s.name="Aman";
        s.setCGPA(8.4);
        System.out.println(s.getCGPA());
    }
}
