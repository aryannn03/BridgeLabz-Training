import java.util.Scanner;
public class ZaraBonus{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        double[]salary=new double[10];
        double[]serviceYears=new double[10];
        double[]bonusAmount=new double[10];
        double[]newSalary=new double[10];
        double totalBonus=0;
        double totalOldSalary=0;
        double totalNewSalary=0;
        for(int i=0;i<10;i++){
            double enteredSalary=sc.nextDouble();
            double enteredYears=sc.nextDouble();
            if(enteredSalary<=0||enteredYears<0){
                i--;
                continue;
            }
            salary[i]=enteredSalary;
            serviceYears[i]=enteredYears;
        }
        for(int i=0;i<10;i++){
            if(serviceYears[i]>5){
                bonusAmount[i]=salary[i]*0.05;
            }else{
                bonusAmount[i]=salary[i]*0.02;
            }
            newSalary[i]=salary[i]+bonusAmount[i];
            totalBonus+=bonusAmount[i];
            totalOldSalary+=salary[i];
            totalNewSalary+=newSalary[i];
        }
        System.out.println("Total Bonus="+totalBonus);
        System.out.println("Total Old Salary="+totalOldSalary);
        System.out.println("Total New Salary="+totalNewSalary);
    }
}
