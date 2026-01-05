import java.util.*;
class InvalidInvoiceException extends Exception{
    InvalidInvoiceException(String message){
        super(message);
    }
}
public class InvoiceGenerator{
    static String[] parseInvoice(String input)throws InvalidInvoiceException{
        if(!input.contains("-")){
            throw new InvalidInvoiceException("Invalid format:Missing '-'");
        }
        return input.split(",");
    }
    static int getTotalAmount(String[] tasks)throws InvalidInvoiceException{
        int total=0;
        for(String task:tasks){
            task=task.trim();
            String[] parts=task.split("-");
            if(parts.length<2){
                throw new InvalidInvoiceException("Invalid task format:"+task);
            }
            String amountPart=parts[1].replace("INR","").trim();
            try{
                int amount=Integer.parseInt(amountPart);
                total+=amount;
            }catch(NumberFormatException e){
                throw new InvalidInvoiceException("Invalid amount in task:"+task);
            }
        }
        return total;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        try{
            System.out.println("Enter invoice details:");
            String input=scanner.nextLine();
            String[] tasks=parseInvoice(input);
            System.out.println("Invoice Items:");
            for(String task:tasks){
                System.out.println(task.trim());
            }
            int total=getTotalAmount(tasks);
            System.out.println("Total Invoice Amount:"+total+" INR");
        }catch(InvalidInvoiceException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}
