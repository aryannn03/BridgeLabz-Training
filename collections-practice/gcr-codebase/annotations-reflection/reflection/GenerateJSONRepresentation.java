import java.lang.reflect.*;

class SampleObject{
    String title;
    int count;
    SampleObject(String title,int count){
        this.title=title;
        this.count=count;
    }
}

public class GenerateJSONRepresentation{
    static String toJson(Object obj)throws Exception{
        StringBuilder sb=new StringBuilder("{");
        Field[] fields=obj.getClass().getDeclaredFields();
        for(Field f:fields){
            f.setAccessible(true);
            sb.append("\"").append(f.getName()).append("\":");
            Object val=f.get(obj);
            if(val instanceof String)
                sb.append("\"").append(val).append("\"");
            else
                sb.append(val);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
    public static void main(String[] args)throws Exception{
        SampleObject obj=new SampleObject("Item",5);
        System.out.println(toJson(obj));
    }
}
