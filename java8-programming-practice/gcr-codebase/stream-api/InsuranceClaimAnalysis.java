import java.util.*;
import java.util.stream.*;

class InsuranceClaim{
    String type;
    double amount;
    InsuranceClaim(String type,double amount){
        this.type=type;
        this.amount=amount;
    }
}

public class InsuranceClaimAnalysis{
    public static void main(String[] args){
        List<InsuranceClaim> claims=Arrays.asList(
            new InsuranceClaim("Health",50000),
            new InsuranceClaim("Vehicle",30000),
            new InsuranceClaim("Health",70000),
            new InsuranceClaim("Life",100000),
            new InsuranceClaim("Vehicle",45000)
        );

        Map<String,Double> avgClaims=claims.stream()
            .collect(Collectors.groupingBy(
                c->c.type,
                Collectors.averagingDouble(c->c.amount)
            ));

        avgClaims.forEach((k,v)->System.out.println(k+" "+v));
    }
}
