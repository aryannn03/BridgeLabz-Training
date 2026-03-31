import java.time.*;
import java.util.*;
import java.util.stream.*;

class GymMember{
    String name;
    LocalDate expiryDate;
    GymMember(String name,LocalDate expiryDate){
        this.name=name;
        this.expiryDate=expiryDate;
    }
}

public class FilteringExpiringMemberships{
    public static void main(String[] args){
        List<GymMember> members=Arrays.asList(
            new GymMember("Aman",LocalDate.now().plusDays(10)),
            new GymMember("Riya",LocalDate.now().plusDays(40)),
            new GymMember("Kunal",LocalDate.now().plusDays(25)),
            new GymMember("Neha",LocalDate.now().plusDays(5))
        );

        LocalDate today=LocalDate.now();
        LocalDate limit=today.plusDays(30);

        members.stream()
            .filter(m->!m.expiryDate.isAfter(limit))
            .forEach(m->System.out.println(m.name+" "+m.expiryDate));
    }
}
