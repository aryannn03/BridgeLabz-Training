import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
    String description();
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
    BugReport[] value();
}
class IssueTracker{
    @BugReport(description="Null pointer issue")
    @BugReport(description="Performance slowdown")
    void process(){
        System.out.println("Processing");
    }
}
public class RepeatableAnnotationDemo{
    public static void main(String[] args)throws Exception{
        Method m=IssueTracker.class.getDeclaredMethod("process");
        BugReport[] bugs=m.getAnnotationsByType(BugReport.class);
        for(BugReport b:bugs)
            System.out.println(b.description());
        new IssueTracker().process();
    }
}
