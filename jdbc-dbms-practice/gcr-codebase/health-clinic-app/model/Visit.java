package model;

public class Visit{
    private int id;
    private int appointmentId;
    private String diagnosis;
    private String notes;

    public Visit(int id,int appointmentId,String diagnosis,String notes){
        this.id=id;
        this.appointmentId=appointmentId;
        this.diagnosis=diagnosis;
        this.notes=notes;
    }

    public int getId(){return id;}
}
