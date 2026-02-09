package dao;

import model.Bill;
import java.util.*;

public class BillDAO{
    private List<Bill> bills=new ArrayList<>();
    private int idCounter=1;

    public Bill generate(int visitId,double amount){
        Bill b=new Bill(idCounter++,visitId,amount);
        bills.add(b);
        return b;
    }

    public List<Bill> unpaid(){
        List<Bill> res=new ArrayList<>();
        for(Bill b:bills){
            if(!b.isPaid())
                res.add(b);
        }
        return res;
    }
}
