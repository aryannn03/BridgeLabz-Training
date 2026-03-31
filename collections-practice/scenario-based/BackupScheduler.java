import java.util.*;
class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}
class BackupTask implements Comparable<BackupTask> {
    String folderPath;
    int priority;
    public BackupTask(String folderPath,int priority) {
        this.folderPath=folderPath;
        this.priority=priority;
    }
    public int compareTo(BackupTask other) {
        return other.priority-this.priority;
    }
    public String toString() {
        return "Path:"+folderPath+" Priority:"+priority;
    }
}

public class BackupScheduler {
    PriorityQueue<BackupTask> queue=new PriorityQueue<>();
    public void addTask(String path,int priority)throws InvalidBackupPathException {
        if(path==null||path.length()==0) {
            throw new InvalidBackupPathException("Invalid backup path");
        }
        queue.add(new BackupTask(path,priority));
        System.out.println("Backup task added");
    }
    public void executeTasks() {
        System.out.println("Executing backup tasks:");
        while(!queue.isEmpty()) {
            BackupTask task=queue.poll();
            System.out.println("Backing up:"+task);
        }
    }
    public static void main(String[] args) {
        BackupScheduler scheduler=new BackupScheduler();
        try {
            scheduler.addTask("C:/System",5);
            scheduler.addTask("D:/Projects",3);
            scheduler.addTask("E:/Photos",4);
        } catch(InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }
        scheduler.executeTasks();
    }
}