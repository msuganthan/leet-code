package stack;

import java.util.Stack;

public class RemoveKthDigit {

    public static void main(String[] args) {
        System.out.println(removeKthDigit("1432219", 3));
    }

    static String removeKthDigit(String num, int k) {
        int len = num.length();

        if (k == len)
            return "0";


        Stack<Character> stack = new Stack<>();
        int i = 0;

        while ( i < num.length()) {

            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
            i++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        sb.reverse();

        //remove all the 0's at the head
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }
}
