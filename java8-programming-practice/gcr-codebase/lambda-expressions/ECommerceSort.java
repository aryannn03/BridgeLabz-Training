import java.util.*;
class Product{
    String name;
    double price;
    double rating;
    int discount;
    Product(String name,double price,double rating,int discount){
        this.name=name;
        this.price=price;
        this.rating=rating;
        this.discount=discount;
    }
    public String toString(){
        return name+" | Price:"+price+" | Rating:"+rating+" | Discount:"+discount+"%";
    }
}

public class ECommerceSort{
    public static void main(String[] args){
        List<Product> products=new ArrayList<>();
        products.add(new Product("Laptop",55000,4.5,10));
        products.add(new Product("Phone",25000,4.8,15));
        products.add(new Product("Headphones",2000,4.2,25));
        System.out.println("Sort by: price/rating/discount");
        Scanner ob=new Scanner(System.in);
        String choice=ob.nextLine();
        if(choice.equals("price")){
            products.sort((a,b)->Double.compare(a.price,b.price));
        }else if(choice.equals("rating")){
            products.sort((a,b)->Double.compare(b.rating,a.rating));
        }else if(choice.equals("discount")){
            products.sort((a,b)->Integer.compare(b.discount,a.discount));
        }
        products.forEach(p->System.out.println(p));
    }
}
