import java.util.*;

class InvalidTimeFormatException extends Exception{
	public InvalidTimeFormatException(String message){
		super(message);
	}
}

public class CinemaTime{
	private List<String> titles=new ArrayList<>();
	private List<String> times=new ArrayList<>();

	public void addMovie(String title,String time) throws InvalidTimeFormatException{
		if(!isValidTime(time)){
			throw new InvalidTimeFormatException("Invalid time format: "+time);
		}
		titles.add(title);
		times.add(time);
	}

	public void searchMovie(String keyword){
		boolean found=false;
		try{
			for(int i=0;i<titles.size();i++){
				if(titles.get(i).contains(keyword)){
					System.out.println(
						String.format("Movie: %s | Time: %s",
						titles.get(i),times.get(i))
					);
					found=true;
				}
			}
			if(!found){
				throw new IndexOutOfBoundsException("No movie found with keyword: "+keyword);
			}
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
	}

	public void displayAllMovies(){
		if(titles.isEmpty()){
			System.out.println("No movies available.");
			return;
		}
		for(int i=0;i<titles.size();i++){
			System.out.println("Movie: "+titles.get(i)+" | Time: "+times.get(i));
		}
	}

	public void printReport(){
		String[] titleArray=titles.toArray(new String[0]);
		String[] timeArray=times.toArray(new String[0]);

		System.out.println("---- Movie Schedule Report ----");
		for(int i=0;i<titleArray.length;i++){
			System.out.println(titleArray[i]+" at "+timeArray[i]);
		}
	}

	private boolean isValidTime(String time){
		if(!time.matches("\\d{2}:\\d{2}"))return false;
		String[] parts=time.split(":");
		int hour=Integer.parseInt(parts[0]);
		int min=Integer.parseInt(parts[1]);
		return hour>=0&&hour<=23&&min>=0&&min<=59;
	}

	public static void main(String[] args){
		CinemaTime manager=new CinemaTime();
		Scanner sc=new Scanner(System.in);
		int choice;

		do{
			System.out.println("\n--- CinemaTime Menu ---");
			System.out.println("1. Add Movie");
			System.out.println("2. Search Movie");
			System.out.println("3. Display All Movies");
			System.out.println("4. Print Report");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");

			choice=sc.nextInt();
			sc.nextLine();

			switch(choice){
				case 1:
					try{
						System.out.print("Enter movie title: ");
						String title=sc.nextLine();
						System.out.print("Enter show time (HH:MM): ");
						String time=sc.nextLine();
						manager.addMovie(title,time);
						System.out.println("Movie added successfully.");
					}
					catch(InvalidTimeFormatException e){
						System.out.println(e.getMessage());
					}
					break;

				case 2:
					System.out.print("Enter search keyword: ");
					String keyword=sc.nextLine();
					manager.searchMovie(keyword);
					break;

				case 3:
					manager.displayAllMovies();
					break;

				case 4:
					manager.printReport();
					break;

				case 5:
					System.out.println("Exiting CinemaTime...");
					break;

				default:
					System.out.println("Invalid choice.");
			}
		}while(choice!=5);

		sc.close();
	}
}
