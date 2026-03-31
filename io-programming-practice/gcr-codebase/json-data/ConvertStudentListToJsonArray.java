import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

class Student{
    String name;
    int age;
    Student(String name,int age){
        this.name=name;
        this.age=age;
    }
}

public class ConvertStudentListToJsonArray{
    public static void main(String[]args){
        List<Student> students=new ArrayList<>();
        students.add(new Student("Aryan",21));
        students.add(new Student("Rohit",26));
        students.add(new Student("Neha",23));

        JSONArray jsonArray=new JSONArray();

        for(Student s:students){
            JSONObject obj=new JSONObject();
            obj.put("name",s.name);
            obj.put("age",s.age);
            jsonArray.put(obj);
        }

        System.out.println(jsonArray.toString());
    }
}
