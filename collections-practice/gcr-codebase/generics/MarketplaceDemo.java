import java.util.*;

abstract class Product{
	double price;
	Product(double price){
		this.price=price;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price=price;
	}
}

class Book extends Product{
	Book(double price){super(price);}
}

class Catalog{
	public static <T extends Product> void applyDiscount(T product,double percent){
		product.setPrice(product.getPrice()*(1-percent/100));
	}
}

public class MarketplaceDemo{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		System.out.print("Enter book price: ");
		double price=sc.nextDouble();

		System.out.print("Enter discount %: ");
		double disc=sc.nextDouble();

		Book book=new Book(price);
		Catalog.applyDiscount(book,disc);

		System.out.println("Final price: "+book.getPrice());
		sc.close();
	}
}
