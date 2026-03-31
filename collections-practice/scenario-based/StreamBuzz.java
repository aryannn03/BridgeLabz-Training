import java.util.*;
class CreatorStats
{
    private String creatorName;
    private double[] weeklyLikes;
    public static List<CreatorStats> engagementBoard=new ArrayList<>();
    public String getCreatorName()
    {
        return creatorName;
    }

    public void setCreatorName(String creatorName)
    {
        this.creatorName=creatorName;
    }

    public double[] getWeeklyLikes()
    {
        return weeklyLikes;
    }

    public void setWeeklyLikes(double[] weeklyLikes)
    {
        this.weeklyLikes=weeklyLikes;
    }
}

public class StreamBuzz
{
    public void registerCreator(CreatorStats record)
    {
        CreatorStats.engagementBoard.add(record);
    }

    public Map<String,Integer> getTopPostCounts(List<CreatorStats> records,double likeThreshold)
    {
        Map<String,Integer> result=new HashMap<>();
        for(CreatorStats creator:records)
        {
            int count=0;
            for(double likes:creator.getWeeklyLikes())
            {
                if(likes>=likeThreshold)
                {
                    count++;
                }
            }
            if(count>0)
            {
                result.put(creator.getCreatorName(),count);
            }
        }
        return result;
    }

    public double calculateAverageLikes()
    {
        double total=0;
        int count=0;
        for(CreatorStats creator:CreatorStats.engagementBoard)
        {
            for(double likes:creator.getWeeklyLikes())
            {
                total+=likes;
                count++;
            }
        }

        if(count==0)
        {
            return 0;
        }
        return total/count;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        StreamBuzz program=new StreamBuzz();
        boolean running=true;
        while(running)
        {
            System.out.println("\n1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1)
            {
                CreatorStats creator=new CreatorStats();
                System.out.println("Enter Creator Name:");
                creator.setCreatorName(sc.nextLine());
                double[] likes=new double[4];
                System.out.println("Enter weekly likes (Week 1 to 4):");
                for(int i=0;i<4;i++)
                {
                    likes[i]=sc.nextDouble();
                }
                creator.setWeeklyLikes(likes);
                program.registerCreator(creator);
                System.out.println("Creator registered successfully");
            }
            else if(choice==2)
            {
                System.out.println("Enter like threshold:");
                double threshold=sc.nextDouble();
                Map<String,Integer> result=program.getTopPostCounts(CreatorStats.engagementBoard,threshold);
                if(result.isEmpty())
                {
                    System.out.println("No top-performing posts this week");
                }
                else
                {
                    for(Map.Entry<String,Integer> entry:result.entrySet())
                    {
                        System.out.println(entry.getKey()+" - "+entry.getValue());
                    }
                }
            }
            else if(choice==3)
            {
                double avg=program.calculateAverageLikes();
                System.out.println("Overall average weekly likes: "+avg);
            }
            else if(choice==4)
            {
                System.out.println("Logging off - Keep Creating with StreamBuzz!");
                running=false;
            }
        }
    }
}