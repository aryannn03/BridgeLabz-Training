import java.util.*;

interface MealPlan{
	String getMealType();
}

class VegetarianMeal implements MealPlan{
	public String getMealType(){return "Vegetarian";}
}

class VeganMeal implements MealPlan{
	public String getMealType(){return "Vegan";}
}

class Meal{
	public static <T extends MealPlan> void generateMeal(T plan){
		System.out.println("Generated Meal: "+plan.getMealType());
	}
}

public class MealPlanDemo{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		System.out.print("Choose Meal (1-Veg, 2-Vegan): ");
		int choice=sc.nextInt();

		if(choice==1)
			Meal.generateMeal(new VegetarianMeal());
		else
			Meal.generateMeal(new VeganMeal());

		sc.close();
	}
}
