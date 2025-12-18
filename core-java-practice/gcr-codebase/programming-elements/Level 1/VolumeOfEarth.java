public class VolumeOfEarth {
    public static void main(String[] args) {
        int radius=6378;
        double pi=3.14d;
        double vol=(4/3)*pi*radius*radius*radius;
        double volMile=vol*1.6;
        System.out.println("The Volume of earth in cubic kilometers is " + vol + " and cubic miles is " + volMile);
    }
}