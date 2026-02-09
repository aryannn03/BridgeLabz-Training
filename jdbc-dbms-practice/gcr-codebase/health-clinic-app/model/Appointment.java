package model;

public class Appointment{
    private int id;
    private int patientId;
    private int doctorId;
    private String date;
    private String status;

    public Appointment(int id,int patientId,int doctorId,String date){
        this.id=id;
        this.patientId=patientId;
        this.doctorId=doctorId;
        this.date=date;
        this.status="SCHEDULED";
    }

    public int getId(){return id;}
    public int getDoctorId(){return doctorId;}
    public String getDate(){return date;}
    public void cancel(){status="CANCELLED";}
    public void complete(){status="COMPLETED";}
}
