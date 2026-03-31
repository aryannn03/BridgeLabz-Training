import java.util.*;

class Invoice{
    String transactionId;
    Invoice(String transactionId){
        this.transactionId=transactionId;
    }
    public String toString(){
        return "Invoice created for Transaction:"+transactionId;
    }
}

public class InvoiceGenerator{
    public static void main(String[] args){
        List<String> transactions=List.of("TXN101","TXN102","TXN103");
        List<Invoice> invoices=transactions.stream().map(Invoice::new).toList();
        invoices.forEach(System.out::println);
    }
}
