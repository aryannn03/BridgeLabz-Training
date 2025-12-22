import java.util.Scanner;
public class RockPaperScissors{
    public static String computerChoice(){
        int value=(int)(Math.random()*3);
        return value==0?"rock":value==1?"paper":"scissors";
    }
    public static int findWinner(String user,String computer){
        if(user.equals(computer)){
            return 0;
        }
        if(user.equals("rock")&&computer.equals("scissors")||
           user.equals("paper")&&computer.equals("rock")||
           user.equals("scissors")&&computer.equals("paper")){
            return 1;
        }
        return -1;
    }
    public static String[][]calculateStats(int userWins,int compWins,int games){
        String[][]stats=new String[2][3];
        stats[0][0]="User";
        stats[0][1]=String.valueOf(userWins);
        stats[0][2]=String.valueOf((userWins*100)/games);
        stats[1][0]="Computer";
        stats[1][1]=String.valueOf(compWins);
        stats[1][2]=String.valueOf((compWins*100)/games);
        return stats;
    }
    public static void display(String[][]table){
        for(int i=0;i<table.length;i++){
            System.out.println(table[i][0]+" "+table[i][1]+" "+table[i][2]+"%");
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int games=sc.nextInt();
        int userWins=0;
        int compWins=0;
        for(int i=0;i<games;i++){
            String user=sc.next();
            String computer=computerChoice();
            int result=findWinner(user,computer);
            if(result==1){
                userWins++;
            }else if(result==-1){
                compWins++;
            }
        }
        display(calculateStats(userWins,compWins,games));
    }
}
