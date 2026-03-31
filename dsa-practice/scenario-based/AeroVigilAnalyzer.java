import java.util.*;
import java.util.regex.Pattern;

class InvalidFlightException extends Exception{
    public InvalidFlightException(String message){
        super(message);
    }
}

class FlightUtil{

    public boolean validateFlightNumber(String flightNumber)throws InvalidFlightException{
        String regex="FL-[1-9]\\d{3}";
        if(!Pattern.matches(regex,flightNumber)){
            throw new InvalidFlightException("The flight number "+flightNumber+" is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName)throws InvalidFlightException{
        if(!(flightName.equals("SpiceJet")
                ||flightName.equals("Vistara")
                ||flightName.equals("IndiGo")
                ||flightName.equals("Air Arabia"))){
            throw new InvalidFlightException("The flight name "+flightName+" is invalid");
        }
        return true;
    }

    public boolean validatePassengerCount(int passengerCount,String flightName)
            throws InvalidFlightException{

        int maxCapacity;

        switch(flightName){
            case "SpiceJet":
                maxCapacity=396;
                break;
            case "Vistara":
                maxCapacity=615;
                break;
            case "IndiGo":
                maxCapacity=230;
                break;
            case "Air Arabia":
                maxCapacity=130;
                break;
            default:
                throw new InvalidFlightException("The flight name "+flightName+" is invalid");
        }

        if(passengerCount<=0||passengerCount>maxCapacity){
            throw new InvalidFlightException("The passenger count "+passengerCount+" is invalid for "+flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName,double currentFuelLevel)
            throws InvalidFlightException{

        double maxFuelCapacity;

        switch(flightName){
            case "SpiceJet":
                maxFuelCapacity=200000;
                break;
            case "Vistara":
                maxFuelCapacity=300000;
                break;
            case "IndiGo":
                maxFuelCapacity=250000;
                break;
            case "Air Arabia":
                maxFuelCapacity=150000;
                break;
            default:
                throw new InvalidFlightException("Invalid fuel level for "+flightName);
        }

        if(currentFuelLevel<0||currentFuelLevel>maxFuelCapacity){
            throw new InvalidFlightException("Invalid fuel level for "+flightName);
        }
        return maxFuelCapacity-currentFuelLevel;
    }
}

public class AeroVigilAnalyzer{

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        FlightUtil util=new FlightUtil();
        try{
            System.out.println("Enter flight details");
            String input=sc.nextLine();
            String[] parts=input.split(":");

            String flightNumber=parts[0];
            String flightName=parts[1];
            int passengerCount=Integer.parseInt(parts[2]);
            double currentFuelLevel=Double.parseDouble(parts[3]);

            util.validateFlightNumber(flightNumber);
            util.validateFlightName(flightName);
            util.validatePassengerCount(passengerCount,flightName);

            double fuelRequired=util.calculateFuelToFillTank(flightName,currentFuelLevel);
            System.out.println("Fuel required to fill the tank: "+fuelRequired+" liters");
        }
        catch(InvalidFlightException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("Invalid input format");
        }
        finally{
            sc.close();
        }
    }
}
