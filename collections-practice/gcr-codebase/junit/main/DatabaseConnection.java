public class DatabaseConnection{
    private boolean connected;

    public void connect(){
        connected=true;
    }

    public void disconnect(){
        connected=false;
    }

    public boolean isConnected(){
        return connected;
    }

    public static void main(String[]args){
        DatabaseConnection db=new DatabaseConnection();
        db.connect();
        System.out.println(db.isConnected());
        db.disconnect();
        System.out.println(db.isConnected());
    }
}
