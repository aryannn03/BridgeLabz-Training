import java.util.*;

abstract class JobRole{
	String role;
	JobRole(String role){
		this.role=role;
	}
	public String toString(){
		return role;
	}
}

class SoftwareEngineer extends JobRole{
	SoftwareEngineer(){super("Software Engineer");}
}

class DataScientist extends JobRole{
	DataScientist(){super("Data Scientist");}
}

class Resume{
	public static void screenResumes(List<? extends JobRole> list){
		for(JobRole r:list){
			System.out.println("Screening: "+r);
		}
	}
}

public class ResumeDemo{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		List<JobRole> roles=new ArrayList<>();

		System.out.print("Enter number of candidates: ");
		int n=sc.nextInt();

		for(int i=0;i<n;i++){
			System.out.print("1-Software 2-DataScientist: ");
			int ch=sc.nextInt();
			if(ch==1)roles.add(new SoftwareEngineer());
			else roles.add(new DataScientist());
		}

		Resume.screenResumes(roles);
		sc.close();
	}
}
