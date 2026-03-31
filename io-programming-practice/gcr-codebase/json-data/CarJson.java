import org.json.JSONObject;

class Car{
    String brand;
    String model;
    int year;
    Car(String brand,String model,int year){
        this.brand=brand;
        this.model=model;
        this.year=year;
    }
}

public class CarJson{
    public static void main(String[]args){
        Car car=new Car("Toyota","Camry",2022);

        JSONObject carJson=new JSONObject();
        carJson.put("brand",car.brand);
        carJson.put("model",car.model);
        carJson.put("year",car.year);

        System.out.println(carJson.toString());
    }
}
