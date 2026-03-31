import java.util.*;

class DuplicateAttendanceException extends Exception{
    public DuplicateAttendanceException(String msg){
        super(msg);
    }
}

class AttendanceManager{
    private Map<String,Set<String>> attendanceMap=new HashMap<>();

    public void markAttendance(String sessionId,String studentId)throws DuplicateAttendanceException{
        attendanceMap.putIfAbsent(sessionId,new HashSet<>());

        if(attendanceMap.get(sessionId).contains(studentId)){
            throw new DuplicateAttendanceException("Attendance already marked");
        }

        attendanceMap.get(sessionId).add(studentId);
    }

    public void removeAttendance(String sessionId,String studentId){
        if(attendanceMap.containsKey(sessionId)){
            attendanceMap.get(sessionId).remove(studentId);
        }
    }

    public void displayAttendance(String sessionId){
        Set<String> students=attendanceMap.get(sessionId);
        if(students!=null){
            System.out.println("Attendance for "+sessionId+":"+students);
        }else{
            System.out.println("No attendance data");
        }
    }
}

public class ClassroomSystem{
    public static void main(String[] args){
        try{
            AttendanceManager manager=new AttendanceManager();

            manager.markAttendance("S1","ST101");
            manager.markAttendance("S1","ST102");

            manager.displayAttendance("S1");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}