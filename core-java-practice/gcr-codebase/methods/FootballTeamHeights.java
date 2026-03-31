public class FootballTeamHeights{
    public static void main(String[] args){
        int[] heights=new int[11];
    
        for(int i=0;i<11;i++)
            heights[i]=150+(int)(Math.random()*101);
    
        System.out.println(shortest(heights));
        System.out.println(tallest(heights));
        System.out.println(mean(heights));
    }
    public static int sum(int[] h){
        int s=0;
        for(int i:h)s+=i;
        return s;
    }
    public static double mean(int[] h){
        return (double)sum(h)/h.length;
    }
    public static int shortest(int[] h){
        int min=h[0];
        for(int i:h)if(i<min)min=i;
        return min;
    }
    public static int tallest(int[] h){
        int max=h[0];
        for(int i:h)if(i>max)max=i;
        return max;
    }
}
