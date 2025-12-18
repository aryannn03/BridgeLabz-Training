public class ProfitLoss {
    public static void main(String[] args) {
        int cp=129;
        int sp=191;
        int profit=sp-cp;
        double profit_percent=(profit*1d/cp)*100;
        System.out.println("The Cost Price is " + cp + " and Selling Price is " + sp +"\nThe Profit is INR " + profit + " and the Profit Percentage is "+ profit_percent);
    }
}
