import java.util.*;

class InvalidRatingException extends Exception{
    public InvalidRatingException(String msg){
        super(msg);
    }
}

class EventFeedbackSystem{
    private Map<Integer,List<Integer>> feedbackMap=new HashMap<>();

    public void addRating(int eventId,int rating)throws InvalidRatingException{
        if(rating<1||rating>5){
            throw new InvalidRatingException("Rating must be between 1 and 5");
        }

        feedbackMap.putIfAbsent(eventId,new ArrayList<>());
        feedbackMap.get(eventId).add(rating);
    }

    public double getAverageRating(int eventId){
        List<Integer> ratings=feedbackMap.get(eventId);
        if(ratings==null||ratings.isEmpty())return 0.0;

        int sum=0;
        for(int r:ratings){
            sum+=r;
        }
        return (double)sum/ratings.size();
    }

    public int getTopRatedEvent(){
        double max=0;
        int topEvent=-1;

        for(int eventId:feedbackMap.keySet()){
            double avg=getAverageRating(eventId);
            if(avg>max){
                max=avg;
                topEvent=eventId;
            }
        }
        return topEvent;
    }
}

public class EventAnalyzer{
    public static void main(String[] args){
        try{
            EventFeedbackSystem system=new EventFeedbackSystem();

            system.addRating(101,5);
            system.addRating(101,4);
            system.addRating(102,3);
            system.addRating(102,5);
            system.addRating(103,2);

            System.out.println("Average Rating Event 101: "+system.getAverageRating(101));
            System.out.println("Top Rated Event: "+system.getTopRatedEvent());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}