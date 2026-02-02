import java.io.*;
import java.util.*;

class Student{
    int id;
    String name;
    int age;
    int marks;

    Student(int id,String name,int age,int marks){
        this.id=id;
        this.name=name;
        this.age=age;
        this.marks=marks;
    }

    public String toString(){
        return id+" "+name+" "+age+" "+marks;
    }
}

public class CSVToStudentConverter{
    public static void main(String[]args){
        String filePath="collections-practice/gcr-codebase/CSV_Data_Handling/students.csv";
        List<Student>list=new ArrayList<>();

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String line;
            while((line=br.readLine())!=null){
                String[]d=line.split(",");
                Student s=new Student(
                    Integer.parseInt(d[0]),
                    d[1],
                    Integer.parseInt(d[2]),
                    Integer.parseInt(d[3])
                );
                list.add(s);
            }
        }catch(IOException e){
            System.out.println("Error");
        }

        for(Student s:list){
            System.out.println(s);
        }
    }
}
