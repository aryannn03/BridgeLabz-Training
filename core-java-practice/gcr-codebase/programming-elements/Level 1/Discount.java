public class Discount {
    public static void main(String[] args) {
        int fee=125000;
        int discount_percent=10;
        int discount=fee/discount_percent;
        System.out.print("The discount amount is INR "+discount+" and final discounte fee is INR "+(fee-discount));
    }
}
