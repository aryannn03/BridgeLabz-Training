import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < asteroids.length; index++) {
            int currentAsteroid = asteroids[index];

            if (stack.isEmpty() || currentAsteroid > 0) {
                stack.push(currentAsteroid);
            } else {
                if (stack.peek() < 0) {
                    stack.push(currentAsteroid);
                } else {
                    int incomingSize = -currentAsteroid;
                    int topAsteroid = stack.pop();

                    if (incomingSize == topAsteroid) {
                        continue;
                    }

                    int largerSize = incomingSize > topAsteroid ? incomingSize : topAsteroid;

                    if (largerSize == topAsteroid) {
                        stack.push(topAsteroid);
                    } else {
                        if (stack.isEmpty()) {
                            stack.push(-incomingSize);
                        } else if (stack.peek() > 0) {
                            index--;
                        } else {
                            stack.push(-incomingSize);
                        }
                    }
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
