package dao;

import model.Visit;
import java.util.*;

public class VisitDAO{
    private List<Visit> visits=new ArrayList<>();
    private int idCounter=1;

    public Visit add(int apptId,String diag,String notes){
        Visit v=new Visit(idCounter++,apptId,diag,notes);
        visits.add(v);
        return v;
    }
}
