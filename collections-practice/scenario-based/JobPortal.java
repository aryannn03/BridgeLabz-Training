import java.util.*;

class InvalidResumeException extends Exception{
    public InvalidResumeException(String msg){
        super(msg);
    }
}

class Resume{
    private String name;
    private Set<String> skills;

    public Resume(String name,Set<String> skills)throws InvalidResumeException{
        if(name==null||skills==null||skills.isEmpty()){
            throw new InvalidResumeException("Invalid Resume Data");
        }
        this.name=name;
        this.skills=skills;
    }

    public String getName(){
        return name;
    }

    public Set<String> getSkills(){
        return skills;
    }
}

class ResumeComparator implements Comparator<Resume>{
    private Set<String> requiredSkills;

    public ResumeComparator(Set<String> requiredSkills){
        this.requiredSkills=requiredSkills;
    }

    public int compare(Resume r1,Resume r2){
        int match1=countMatch(r1);
        int match2=countMatch(r2);
        return match2-match1;
    }

    private int countMatch(Resume r){
        int count=0;
        for(String skill:r.getSkills()){
            if(requiredSkills.contains(skill)){
                count++;
            }
        }
        return count;
    }
}

public class JobPortal{
    public static void main(String[] args){
        try{
            List<Resume> resumes=new ArrayList<>();

            resumes.add(new Resume("Amit",new HashSet<>(Arrays.asList("Java","SQL","Spring"))));
            resumes.add(new Resume("Neha",new HashSet<>(Arrays.asList("Python","ML","SQL"))));
            resumes.add(new Resume("Ravi",new HashSet<>(Arrays.asList("Java","Spring","React"))));

            Set<String> requiredSkills=new HashSet<>(Arrays.asList("Java","Spring"));

            Collections.sort(resumes,new ResumeComparator(requiredSkills));

            System.out.println("Shortlisted Resumes:");
            for(Resume r:resumes){
                System.out.println(r.getName()+" -> "+r.getSkills());
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}