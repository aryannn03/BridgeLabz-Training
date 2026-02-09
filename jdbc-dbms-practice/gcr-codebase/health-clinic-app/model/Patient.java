package model;

public class Patient{
    private int id;
    private String name;
    private String dob;
    private String phone;
    private String email;
    private String address;
    private String bloodGroup;

    public Patient(int id,String name,String dob,String phone,String email,String address,String bloodGroup){
        this.id=id;
        this.name=name;
        this.dob=dob;
        this.phone=phone;
        this.email=email;
        this.address=address;
        this.bloodGroup=bloodGroup;
    }

    public int getId(){return id;}
    public String getPhone(){return phone;}
    public String getEmail(){return email;}
    public String getName(){return name;}
}
