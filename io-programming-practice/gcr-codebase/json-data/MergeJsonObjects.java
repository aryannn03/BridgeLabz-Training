import org.json.JSONObject;

class User{
    String name;
    String email;
    User(String name,String email){
        this.name=name;
        this.email=email;
    }
}

class Address{
    String city;
    String zip;
    Address(String city,String zip){
        this.city=city;
        this.zip=zip;
    }
}

public class MergeJsonObjects{
    public static void main(String[]args){
        User user=new User("Aryan","aryan@example.com");
        Address address=new Address("Mumbai","400701");

        JSONObject userJson=new JSONObject();
        userJson.put("name",user.name);
        userJson.put("email",user.email);

        JSONObject addressJson=new JSONObject();
        addressJson.put("city",address.city);
        addressJson.put("zip",address.zip);

        JSONObject mergedJson=new JSONObject(userJson.toString());
        for(String key:addressJson.keySet())
            mergedJson.put(key,addressJson.get(key));

        System.out.println(mergedJson.toString());
    }
}
