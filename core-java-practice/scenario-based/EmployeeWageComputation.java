public class EmployeeWageComputation{
    public static final int IS_PART_TIME=1;
    public static final int IS_FULL_TIME=2;
    public static final int EMP_RATE_PER_HOUR=20;
    public static final int PART_TIME_HOURS=4;
    public static final int FULL_TIME_HOURS=8;
    public static final int NUM_OF_WORKING_DAYS=20;
    public static final int MAX_HRS_IN_MONTH=100;

    public static void main(String[]args){
        displayWelcome();
        checkAttendance();
        calculateDailyWage();
        calculatePartTimeWage();
        calculateWageUsingSwitch();
        calculateMonthlyWage();
        calculateWageTillCondition();
    }

    // UC 0
    public static void displayWelcome(){
        System.out.println("Welcome to Employee Wage Computation Program");
        System.out.println("--------------------------------------------");
    }

    // UC 1
    public static void checkAttendance(){
        int empCheck=(int)Math.floor(Math.random()*10)%2;
        if(empCheck==1)
            System.out.println("UC1: Employee is Present");
        else
            System.out.println("UC1: Employee is Absent");
    }

    // UC 2
    public static void calculateDailyWage(){
        int empHrs=FULL_TIME_HOURS;
        int empWage=empHrs*EMP_RATE_PER_HOUR;
        System.out.println("UC2: Daily Employee Wage="+empWage);
    }

    // UC 3
    public static void calculatePartTimeWage(){
        int empHrs=PART_TIME_HOURS;
        int empWage=empHrs*EMP_RATE_PER_HOUR;
        System.out.println("UC3: Part Time Employee Wage="+empWage);
    }

    // UC 4
    public static void calculateWageUsingSwitch(){
        int empHrs=0;
        int empCheck=(int)Math.floor(Math.random()*10)%3;

        switch(empCheck){
            case IS_PART_TIME:
                empHrs=PART_TIME_HOURS;
                System.out.println("UC4: Employee is Part Time");
                break;
            case IS_FULL_TIME:
                empHrs=FULL_TIME_HOURS;
                System.out.println("UC4: Employee is Full Time");
                break;
            default:
                empHrs=0;
                System.out.println("UC4: Employee is Absent");
        }

        int empWage=empHrs*EMP_RATE_PER_HOUR;
        System.out.println("UC4: Employee Wage="+empWage);
    }

    // UC 5
    public static void calculateMonthlyWage(){
        int totalEmpWage=0;

        for(int day=1;day<=NUM_OF_WORKING_DAYS;day++){
            int empHrs=0;
            int empCheck=(int)Math.floor(Math.random()*10)%3;

            switch(empCheck){
                case IS_PART_TIME:
                    empHrs=PART_TIME_HOURS;
                    break;
                case IS_FULL_TIME:
                    empHrs=FULL_TIME_HOURS;
                    break;
                default:
                    empHrs=0;
            }

            int dailyWage=empHrs*EMP_RATE_PER_HOUR;
            totalEmpWage+=dailyWage;
        }

        System.out.println("UC5: Monthly Employee Wage="+totalEmpWage);
    }

    // UC 6
    public static void calculateWageTillCondition(){
        int totalEmpHrs=0;
        int totalWorkingDays=0;

        while(totalEmpHrs<MAX_HRS_IN_MONTH&&totalWorkingDays<NUM_OF_WORKING_DAYS){
            totalWorkingDays++;
            int empHrs=0;
            int empCheck=(int)Math.floor(Math.random()*10)%3;

            switch(empCheck){
                case IS_PART_TIME:
                    empHrs=PART_TIME_HOURS;
                    break;
                case IS_FULL_TIME:
                    empHrs=FULL_TIME_HOURS;
                    break;
                default:
                    empHrs=0;
            }

            totalEmpHrs+=empHrs;
            System.out.println("Day "+totalWorkingDays+" | Emp Hrs="+empHrs);
        }

        int totalEmpWage=totalEmpHrs*EMP_RATE_PER_HOUR;
        System.out.println("UC6: Total Working Days="+totalWorkingDays);
        System.out.println("UC6: Total Working Hours="+totalEmpHrs);
        System.out.println("UC6: Total Employee Wage="+totalEmpWage);
    }
}
