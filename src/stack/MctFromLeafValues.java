package stack;

import java.util.Stack;

/**
 * Created by msuganthan on 21/8/20.
 */
public class MctFromLeafValues {

    public static void main(String[] args) {
        mctFromLeafValues(new int[]{6, 2, 4});
    }

    static int mctFromLeafValues(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);

        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }

        while (stack.size() > 2)
            res += stack.pop() * stack.peek();

        return res;
    }
}


