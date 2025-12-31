public class Product{
    String productName;
    double price;
    static int totalProducts;

    public Product(String productName,double price){
        this.productName=productName;
        this.price=price;
        totalProducts++;
    }

    void displayProductDetails(){
        System.out.println(productName+" "+price);
    }

    static void displayTotalProducts(){
        System.out.println(totalProducts);
    }

    public static void main(String[]args){
        new Product("Pen",10);
        new Product("Book",50);
        displayTotalProducts();
    }
}
