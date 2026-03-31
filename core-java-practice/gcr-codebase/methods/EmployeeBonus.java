public class EmployeeBonus{

    public static double[][] generateEmployeeData(){
        double[][] data=new double[10][2];

        for(int i=0;i<10;i++){
            data[i][0]=10000+(int)(Math.random()*90000);
            data[i][1]=1+(int)(Math.random()*10);
        }
        return data;
    }
    public static double[][] calculateBonus(double[][] data){
        double[][] result=new double[10][3];
        for(int i=0;i<10;i++){
            double salary=data[i][0];
            double years=data[i][1];
            double bonusRate=years>5?0.05:0.02;
            double bonus=salary*bonusRate;
            double newSalary=salary+bonus;
            result[i][0]=salary;
            result[i][1]=newSalary;
            result[i][2]=bonus;
        }
        return result;
    }
    public static void calculateTotals(double[][] result){
        double oldSum=0,newSum=0,bonusSum=0;

        System.out.println("OldSalary NewSalary Bonus");

        for(int i=0;i<10;i++){
            oldSum+=result[i][0];
            newSum+=result[i][1];
            bonusSum+=result[i][2];
            System.out.println((int)result[i][0]+" "+(int)result[i][1]+" "+(int)result[i][2]);
        }

        System.out.println(oldSum+" "+newSum+" "+bonusSum);
    }
    public static void main(String[] args){
        double[][] data=generateEmployeeData();
        double[][] result=calculateBonus(data);
        calculateTotals(result);
    }
}
