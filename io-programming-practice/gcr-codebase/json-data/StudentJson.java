import org.json.JSONArray;
import org.json.JSONObject;

class Student{
    String name;
    int age;
    String[] subjects;
    Student(String name,int age,String[] subjects){
        this.name=name;
        this.age=age;
        this.subjects=subjects;
    }
}

public class StudentJson{
    public static void main(String[]args){
        String[] subjects={"Maths","Physics","Computer Science"};
        Student student=new Student("Aryan",21,subjects);

        JSONArray subjectsArray=new JSONArray();
        for(String subject:student.subjects)
            subjectsArray.put(subject);

        JSONObject studentJson=new JSONObject();
        studentJson.put("name",student.name);
        studentJson.put("age",student.age);
        studentJson.put("subjects",subjectsArray);

        System.out.println(studentJson.toString());
    }
}
