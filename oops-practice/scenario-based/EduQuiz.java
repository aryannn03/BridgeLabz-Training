class EduQuiz {

    static int calculateScore(String[] cor,String[] stu){
        int sc=0;
        for(int i=0;i<cor.length;i++){
            if(cor[i].equalsIgnoreCase(stu[i]))
                sc++;
        }
        return sc;
    }

    public static void main(String[] args){

        String[] cor={"A","B","C","D","A","C","B","D","A","C"};
        String[] stu={"a","B","D","D","A","c","B","A","A","c"};

        int score=calculateScore(cor,stu);

        for(int i=0;i<cor.length;i++){
            if(cor[i].equalsIgnoreCase(stu[i]))
                System.out.println("Question "+(i+1)+": Correct");
            else
                System.out.println("Question "+(i+1)+": Incorrect");
        }

        double per=(score*100.0)/cor.length;

        System.out.println("\nScore: "+score+"/"+cor.length);
        System.out.println("Percentage: "+per+"%");

        if(per>=40)
            System.out.println("Result: PASS");
        else
            System.out.println("Result: FAIL");
    }
}
