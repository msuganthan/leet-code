package stack;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {

    }

    private HashMap<Character, Character> mappings;

    public IsValid() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
