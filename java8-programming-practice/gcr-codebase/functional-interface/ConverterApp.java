interface UnitConverter{
    static double kmToMiles(double km){
        return km*0.621371;
    }
    static double kgToPounds(double kg){
        return kg*2.20462;
    }
}

public class ConverterApp{
    public static void main(String[] args){
        System.out.println("Miles:"+UnitConverter.kmToMiles(10));
        System.out.println("Pounds:"+UnitConverter.kgToPounds(5));
    }
}
