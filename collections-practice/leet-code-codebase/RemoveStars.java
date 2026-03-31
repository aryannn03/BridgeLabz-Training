import java.util.Stack;

public class RemoveStars {
    public String removeStars(String input) {
        Stack<Character> stack = new Stack<>();
        char[] characters = input.toCharArray();

        for (char currentChar : characters) {
            if (currentChar != '*') {
                stack.push(currentChar);
            } else {
                stack.pop();
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }
}
