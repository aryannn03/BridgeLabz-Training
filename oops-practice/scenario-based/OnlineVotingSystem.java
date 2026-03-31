import java.util.*;

class DuplicateVoteException extends Exception{
    DuplicateVoteException(String msg){
        super(msg);
    }
}

abstract class ElectionService{
    abstract void registerVoter(Voter v);
    abstract void addCandidate(Candidate c);
    abstract void castVote(int voterId,int candidateId) throws DuplicateVoteException;
    abstract void declareResult();
}

class Voter{
    int voterId;
    String name;
    boolean hasVoted;

    Voter(int voterId,String name){
        this.voterId=voterId;
        this.name=name;
        this.hasVoted=false;
    }
}

class Candidate{
    int candidateId;
    String name;
    int votes;

    Candidate(int candidateId,String name){
        this.candidateId=candidateId;
        this.name=name;
        this.votes=0;
    }
}

class Vote{
    int voterId;
    int candidateId;

    Vote(int voterId,int candidateId){
        this.voterId=voterId;
        this.candidateId=candidateId;
    }
}

class Election extends ElectionService{
    Map<Integer,Voter> voters=new HashMap<>();
    Map<Integer,Candidate> candidates=new HashMap<>();
    List<Vote> votes=new ArrayList<>();

    void registerVoter(Voter v){
        voters.put(v.voterId,v);
        System.out.println("Voter Registered");
    }

    void addCandidate(Candidate c){
        candidates.put(c.candidateId,c);
        System.out.println("Candidate Added");
    }

    void castVote(int voterId,int candidateId) throws DuplicateVoteException{
        Voter v=voters.get(voterId);
        Candidate c=candidates.get(candidateId);

        if(v==null || c==null){
            System.out.println("Invalid Voter or Candidate");
            return;
        }

        if(v.hasVoted){
            throw new DuplicateVoteException("Voter has already voted");
        }

        votes.add(new Vote(voterId,candidateId));
        c.votes++;
        v.hasVoted=true;
        System.out.println("Vote Cast Successfully");
    }

    void declareResult(){
        System.out.println("Election Results");
        for(Candidate c:candidates.values()){
            System.out.println(c.name+" : "+c.votes+" votes");
        }
    }
}

public class OnlineVotingSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Election election=new Election();

        while(true){
            System.out.println("1.Register Voter");
            System.out.println("2.Add Candidate");
            System.out.println("3.Cast Vote");
            System.out.println("4.Declare Result");
            System.out.println("0.Exit");
            System.out.print("Choice: ");
            int ch=sc.nextInt();

            if(ch==0) break;

            try{
                switch(ch){
                    case 1:
                        System.out.print("Voter ID: ");
                        int vid=sc.nextInt();
                        sc.nextLine();
                        System.out.print("Voter Name: ");
                        String vname=sc.nextLine();
                        election.registerVoter(new Voter(vid,vname));
                        break;

                    case 2:
                        System.out.print("Candidate ID: ");
                        int cid=sc.nextInt();
                        sc.nextLine();
                        System.out.print("Candidate Name: ");
                        String cname=sc.nextLine();
                        election.addCandidate(new Candidate(cid,cname));
                        break;

                    case 3:
                        System.out.print("Voter ID: ");
                        int voterId=sc.nextInt();
                        System.out.print("Candidate ID: ");
                        int candidateId=sc.nextInt();
                        election.castVote(voterId,candidateId);
                        break;

                    case 4:
                        election.declareResult();
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
            }catch(DuplicateVoteException e){
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
