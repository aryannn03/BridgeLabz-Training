import java.util.*;

class Student{
	String name;
	int marks;

	Student(String name,int marks){
		this.name=name;
		this.marks=marks;
	}

	public String toString(){
		return name+" "+marks;
	}
}

public class EduResults{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		System.out.print("Enter number of districts: ");
		int d=sc.nextInt();
		sc.nextLine();

		List<Student> allStudents=new ArrayList<>();

		for(int i=0;i<d;i++){
			System.out.print("Enter number of students in district "+(i+1)+": ");
			int n=sc.nextInt();
			sc.nextLine();

			for(int j=0;j<n;j++){
				System.out.print("Enter student name: ");
				String name=sc.nextLine();
				System.out.print("Enter marks: ");
				int marks=sc.nextInt();
				sc.nextLine();
				allStudents.add(new Student(name,marks));
			}
		}

		mergeSort(allStudents,0,allStudents.size()-1);

		System.out.println("\nFinal State Rank List:");
		for(Student s:allStudents){
			System.out.println(s);
		}

		sc.close();
	}

	static void mergeSort(List<Student> list,int left,int right){
		if(left<right){
			int mid=(left+right)/2;
			mergeSort(list,left,mid);
			mergeSort(list,mid+1,right);
			merge(list,left,mid,right);
		}
	}

	static void merge(List<Student> list,int left,int mid,int right){
		List<Student> temp=new ArrayList<>();
		int i=left,j=mid+1;

		while(i<=mid&&j<=right){
			if(list.get(i).marks>list.get(j).marks){
				temp.add(list.get(i++));
			}else{
				temp.add(list.get(j++));
			}
		}

		while(i<=mid)temp.add(list.get(i++));
		while(j<=right)temp.add(list.get(j++));

		for(int k=0;k<temp.size();k++){
			list.set(left+k,temp.get(k));
		}
	}
}
