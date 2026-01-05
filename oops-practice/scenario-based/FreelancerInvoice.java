import java.util.*;
public class FreelancerInvoice{
    static String[] parseInvoice(String input){
        return input.split(",");
    }
    static int getTotalAmount(String[] tasks){
        int total=0;
        for(String task:tasks){
            task=task.trim();
            String[] parts=task.split("-");
            String amountPart=parts[1].replace("INR","").trim();
            int amount=Integer.parseInt(amountPart);
            total+=amount;
        }
        return total;
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter invoice input:");
        String input=ob.nextLine();
        String[] tasks=parseInvoice(input);
        System.out.println("Invoice Items:");
        for(String task:tasks){
            System.out.println(task.trim());
        }
        int total=getTotalAmount(tasks);
        System.out.println("Total Invoice Amount:"+total+" INR");
    }
}
