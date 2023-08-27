package stack;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for(String token: tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
