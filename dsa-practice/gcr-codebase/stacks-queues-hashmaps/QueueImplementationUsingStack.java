import java.util.*;

public class QueueImplementationUsingStack {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter data to enqueue: ");
                    int data = sc.nextInt();
                    enqueue(data, stack1);
                    break;
                case 2:
                    dequeue(stack1, stack2);
                    if(!stack2.isEmpty()){
                        System.out.println("Dequeued: " + stack2.pop());
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }   
    public static void enqueue(int data, Stack<Integer> stack1) {
        stack1.push(data);
    }
    public static void dequeue(Stack<Integer> stack1, Stack<Integer> stack2) {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }
}
