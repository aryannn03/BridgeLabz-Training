import java.io.Serializable;
class BackupData implements Serializable{
    String name;
    BackupData(String name){
        this.name=name;
    }
    void display(){
        System.out.println("Name:"+name);
    }
}

public class BackupApp{
    public static void main(String[] args){
        BackupData data=new BackupData("parth7800");
        data.display();
        System.out.println("Backup data is ready for serialization");
    }
}
