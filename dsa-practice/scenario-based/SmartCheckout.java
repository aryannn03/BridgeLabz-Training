import java.util.*;

class Customer{
	String name;
	List<String> items;

	Customer(String name,List<String> items){
		this.name=name;
		this.items=items;
	}
}

public class SmartCheckout{
	private static Queue<Customer> queue=new LinkedList<>();
	private static HashMap<String,Integer> priceMap=new HashMap<>();
	private static HashMap<String,Integer> stockMap=new HashMap<>();

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		initializeStore();
		int choice;

		do{
			System.out.println("\n1.Add Customer");
			System.out.println("2.Process Billing");
			System.out.println("3.Display Queue");
			System.out.println("4.Display Stock");
			System.out.println("5.Exit");
			System.out.print("Enter choice: ");
			choice=sc.nextInt();
			sc.nextLine();

			switch(choice){
				case 1:
					addCustomer(sc);
					break;
				case 2:
					processBilling();
					break;
				case 3:
					displayQueue();
					break;
				case 4:
					displayStock();
					break;
				case 5:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice");
			}
		}while(choice!=5);

		sc.close();
	}

	private static void initializeStore(){
		priceMap.put("Milk",50);
		priceMap.put("Bread",40);
		priceMap.put("Rice",60);
		priceMap.put("Sugar",45);

		stockMap.put("Milk",10);
		stockMap.put("Bread",8);
		stockMap.put("Rice",15);
		stockMap.put("Sugar",12);
	}

	private static void addCustomer(Scanner sc){
		System.out.print("Enter customer name: ");
		String name=sc.nextLine();

		System.out.print("Enter number of items: ");
		int n=sc.nextInt();
		sc.nextLine();

		List<String> items=new ArrayList<>();
		for(int i=0;i<n;i++){
			System.out.print("Enter item name: ");
			items.add(sc.nextLine());
		}

		queue.add(new Customer(name,items));
		System.out.println("Customer added");
	}

	private static void processBilling(){
		if(queue.isEmpty()){
			System.out.println("Queue empty");
			return;
		}

		Customer c=queue.poll();
		int total=0;

		System.out.println("Billing for "+c.name);
		for(String item:c.items){
			if(priceMap.containsKey(item)&&stockMap.get(item)>0){
				total+=priceMap.get(item);
				stockMap.put(item,stockMap.get(item)-1);
				System.out.println(item+" ₹"+priceMap.get(item));
			}else{
				System.out.println(item+" unavailable");
			}
		}
		System.out.println("Total Bill ₹"+total);
	}

	private static void displayQueue(){
		if(queue.isEmpty()){
			System.out.println("No customers");
			return;
		}
		for(Customer c:queue){
			System.out.println(c.name);
		}
	}

	private static void displayStock(){
		for(String item:stockMap.keySet()){
			System.out.println(item+" -> "+stockMap.get(item));
		}
	}
}
