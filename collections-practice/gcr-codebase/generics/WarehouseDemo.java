import java.util.*;
abstract class WarehouseItem{
	protected String name;
	public WarehouseItem(String name){
		this.name=name;
	}
	@Override
	public String toString(){
		return name;
	}
}
class Electronics extends WarehouseItem{
	public Electronics(String name){
		super(name);
	}
}
class Groceries extends WarehouseItem{
	public Groceries(String name){
		super(name);
	}
}
class Storage<T extends WarehouseItem>{
	private List<T> items=new ArrayList<>();

	public void addItem(T item){
		items.add(item);
	}

	public List<T> getItems(){
		return items;
	}
	public static void displayItems(List<? extends WarehouseItem> list){
		for(WarehouseItem item:list){
			System.out.println(item);
		}
	}
}

public class WarehouseDemo{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		Storage<Electronics> electronicsStorage=new Storage<>();
		Storage<Groceries> groceriesStorage=new Storage<>();

		System.out.print("Enter number of electronics items: ");
		int eCount=sc.nextInt();
		sc.nextLine();

		for(int i=0;i<eCount;i++){
			System.out.print("Enter electronics item name: ");
			String name=sc.nextLine();
			electronicsStorage.addItem(new Electronics(name));
		}

		System.out.print("\nEnter number of grocery items: ");
		int gCount=sc.nextInt();
		sc.nextLine();

		for(int i=0;i<gCount;i++){
			System.out.print("Enter grocery item name: ");
			String name=sc.nextLine();
			groceriesStorage.addItem(new Groceries(name));
		}

		System.out.println("\n Stored Electronics ");
		Storage.displayItems(electronicsStorage.getItems());

		System.out.println("\n Stored Groceries ");
		Storage.displayItems(groceriesStorage.getItems());

		sc.close();
	}
}
