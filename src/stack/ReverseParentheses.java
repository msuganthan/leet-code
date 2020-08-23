package stack;

import java.util.Stack;

/**
 * Created by msuganthan on 21/8/20.
 */
public class ReverseParentheses {

    public static void main(String[] args) {
        reverseParentheses("(abcd)");
    }

    static String reverseParentheses(String s) {
        int N                 = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair            = new int[N];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, d = 1; i < N; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else
                stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
