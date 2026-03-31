import java.util.*;

abstract class CourseType{
	String name;
	CourseType(String name){
		this.name=name;
	}
	public String toString(){
		return name;
	}
}

class ExamCourse extends CourseType{
	ExamCourse(String name){super(name);}
}

class Course<T extends CourseType>{
	List<T> courses=new ArrayList<>();

	void addCourse(T c){
		courses.add(c);
	}

	static void showCourses(List<? extends CourseType> list){
		for(CourseType c:list){
			System.out.println(c);
		}
	}
}

public class UniversityDemo{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Course<ExamCourse> examCourses=new Course<>();

		System.out.print("Enter number of exam courses: ");
		int n=sc.nextInt();
		sc.nextLine();

		for(int i=0;i<n;i++){
			System.out.print("Enter course name: ");
			examCourses.addCourse(new ExamCourse(sc.nextLine()));
		}

		System.out.println("Courses:");
		Course.showCourses(examCourses.courses);
		sc.close();
	}
}
