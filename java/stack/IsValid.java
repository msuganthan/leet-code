package stack;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {

    public boolean isValid(String s) {
        if(s.length() == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            } else if(s.charAt(i) == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            } else if(s.charAt(i) == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            } else if(s.charAt(i) == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
