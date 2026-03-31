public class TemperatureConverter{
    public double celsiusToFahrenheit(double celsius){
        return (celsius*9/5)+32;
    }
    public double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit-32)*5/9;
    }
    public static void main(String[]args){
        TemperatureConverter t=new TemperatureConverter();
        System.out.println(t.celsiusToFahrenheit(0));
        System.out.println(t.fahrenheitToCelsius(32));
    }
}
