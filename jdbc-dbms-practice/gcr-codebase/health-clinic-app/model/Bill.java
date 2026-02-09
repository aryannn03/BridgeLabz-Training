package model;

public class Bill{
    private int id;
    private int visitId;
    private double amount;
    private boolean paid=false;

    public Bill(int id,int visitId,double amount){
        this.id=id;
        this.visitId=visitId;
        this.amount=amount;
    }

    public void pay(){paid=true;}
    public boolean isPaid(){return paid;}
}
