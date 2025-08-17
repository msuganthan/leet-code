package stack;

import java.util.Stack;

/**
 * Created by msuganthan on 21/8/20.
 */
public class SteriodCollison {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            collision:
            {
                //stack peek is positive and ast is negative
                while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == ast)
                        stack.pop();
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
