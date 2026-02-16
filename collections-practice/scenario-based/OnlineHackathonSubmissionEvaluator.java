import java.util.*;

class LateSubmissionException extends Exception{
    public LateSubmissionException(String msg){
        super(msg);
    }
}

class Participant{
    private String name;
    private boolean late;
    private Map<Integer,Boolean> results=new HashMap<>();
    public Participant(String name,boolean late){
        this.name=name;
        this.late=late;
    }
    public String getName(){
        return name;
    }
    public void addResult(int questionId,boolean passed){
        results.put(questionId,passed);
    }
    public int calculateScore()throws LateSubmissionException{
        if(late){
            throw new LateSubmissionException("Late");
        }
        int score=0;
        for(Boolean b:results.values()){
            if(b){
                score++;
            }
        }
        return score;
    }
}

public class OnlineHackathonSubmissionEvaluator{
    public static void main(String[] args){
        List<Participant> participants=new ArrayList<>();
        Participant p1=new Participant("Aryan",false);
        Participant p2=new Participant("Rahul",false);
        Participant p3=new Participant("Karan",true);

        p1.addResult(1,true);
        p1.addResult(2,true);
        p1.addResult(3,false);

        p2.addResult(1,true);
        p2.addResult(2,false);
        p2.addResult(3,true);

        p3.addResult(1,true);
        p3.addResult(2,true);

        participants.add(p1);
        participants.add(p2);
        participants.add(p3);

        participants.sort(new Comparator<Participant>(){
            public int compare(Participant a,Participant b){
                try{
                    return Integer.compare(b.calculateScore(),a.calculateScore());
                }catch(LateSubmissionException e){
                    return 0;
                }
            }
        });

        System.out.println("Leaderboard");
        for(Participant p:participants){
            try{
                System.out.println(p.getName()+"="+p.calculateScore());
            }catch(LateSubmissionException e){
                System.out.println(p.getName()+"=Disqualified");
            }
        }
    }
}
