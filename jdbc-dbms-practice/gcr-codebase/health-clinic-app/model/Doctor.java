package model;

public class Doctor{
    private int id;
    private String name;
    private String specialty;
    private double fee;
    private boolean active=true;

    public Doctor(int id,String name,String specialty,double fee){
        this.id=id;
        this.name=name;
        this.specialty=specialty;
        this.fee=fee;
    }

    public int getId(){return id;}
    public String getSpecialty(){return specialty;}
    public double getFee(){return fee;}
    public boolean isActive(){return active;}
    public void deactivate(){active=false;}
}
