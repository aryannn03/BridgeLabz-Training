public class WeeklyTemperatureAnalysis {

    public static void analyzeTemperature(float[][]temp){
        float maxDayAvg=Float.MIN_VALUE;
        float minDayAvg=Float.MAX_VALUE;
        int hotDay=0,coldDay=0;

        for(int i=0;i<7;i++){
            float sum=0;
            for(int j=0;j<24;j++){
                sum+=temp[i][j];
            }
            float avg=sum/24;
            System.out.println("Day "+i+" Average Temperature:"+avg);

            if(avg>maxDayAvg){
                maxDayAvg=avg;
                hotDay=i;
            }
            if(avg<minDayAvg){
                minDayAvg=avg;
                coldDay=i;
            }
        }

        System.out.println("Hottest Day:Day "+hotDay);
        System.out.println("Coldest Day:Day "+coldDay);
    }

    public static void main(String[]args){
        float[][]weekTemp=new float[7][24];

        for(int i=0;i<7;i++){
            for(int j=0;j<24;j++){
                weekTemp[i][j]=20+(float)Math.random()*15;
            }
        }

        analyzeTemperature(weekTemp);
    }
}