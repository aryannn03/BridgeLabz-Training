public class BackgroundJob{
    public static void main(String[] args){
        Runnable job=()->{
            System.out.println("Job started...");
            System.out.println("Job running in background...");
            System.out.println("Job finished");
        };
        Thread t=new Thread(job);
        t.start();
    }
}
