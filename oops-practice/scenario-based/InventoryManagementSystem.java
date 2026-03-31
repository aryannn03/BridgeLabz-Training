import java.util.*;

interface AlertService{
    void lowStockAlert(Product p);
}

class OutOfStockException extends Exception{
    OutOfStockException(String msg){
        super(msg);
    }
}

class Product{
    private int productId;
    private String productName;
    private int quantity;

    Product(int productId,String productName,int quantity){
        this.productId=productId;
        this.productName=productName;
        this.quantity=quantity;
    }

    public int getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
}

class Inventory implements AlertService{
    private Map<Integer,Product> products=new HashMap<>();
    private static final int LOW_STOCK_LIMIT=5;

    public void addProduct(Product p){
        products.put(p.getProductId(),p);
        System.out.println("Product added successfully");
    }

    public void updateStock(int productId,int qty)throws OutOfStockException{
        if(!products.containsKey(productId)){
            System.out.println("Product not found");
            return;
        }
        if(qty<=0){
            throw new OutOfStockException("Stock cannot be zero or negative");
        }
        Product p=products.get(productId);
        p.setQuantity(qty);
        System.out.println("Stock updated");
        if(qty<=LOW_STOCK_LIMIT){
            lowStockAlert(p);
        }
    }

    public void viewStock(){
        if(products.isEmpty()){
            System.out.println("Inventory empty");
            return;
        }
        for(Product p:products.values()){
            System.out.println("ID:"+p.getProductId()+" Name:"+p.getProductName()+" Qty:"+p.getQuantity());
        }
    }

    public void lowStockAlert(Product p){
        System.out.println("ALERT: Low stock for "+p.getProductName());
    }
}

public class InventoryManagementSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Inventory inventory=new Inventory();

        while(true){
            System.out.println("1.Add Product");
            System.out.println("2.Update Stock");
            System.out.println("3.View Inventory");
            System.out.println("0.Exit");
            System.out.print("Enter choice: ");
            int choice=sc.nextInt();

            try{
                switch(choice){
                    case 1:
                        System.out.print("Enter Product ID: ");
                        int id=sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Product Name: ");
                        String name=sc.nextLine();
                        System.out.print("Enter Quantity: ");
                        int qty=sc.nextInt();
                        inventory.addProduct(new Product(id,name,qty));
                        break;

                    case 2:
                        System.out.print("Enter Product ID: ");
                        int pid=sc.nextInt();
                        System.out.print("Enter New Quantity: ");
                        int q=sc.nextInt();
                        inventory.updateStock(pid,q);
                        break;

                    case 3:
                        inventory.viewStock();
                        break;

                    case 0:
                        System.out.println("Exiting system");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }catch(OutOfStockException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
