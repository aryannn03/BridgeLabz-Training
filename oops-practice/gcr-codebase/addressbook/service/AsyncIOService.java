package service;

import java.util.concurrent.*;

public class AsyncIOService {

    private static ExecutorService executor=Executors.newFixedThreadPool(3);

    // UC17
    public static void runAsync(Runnable task){
        executor.submit(task);
    }
}