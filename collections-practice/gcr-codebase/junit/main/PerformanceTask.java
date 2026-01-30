public class PerformanceTask{
    public String longRunningTask() throws InterruptedException{
        Thread.sleep(3000);
        return "Done";
    }
    public static void main(String[]args) throws InterruptedException{
        PerformanceTask p=new PerformanceTask();
        System.out.println(p.longRunningTask());
    }
}
