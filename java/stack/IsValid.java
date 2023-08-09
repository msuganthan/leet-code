package stack;

import java.util.Stack;

public class IsValid {

    public boolean isValid(String s) {
        if(s.length() == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else if(c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            } else if(c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            } else if(c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     *     def isValid(self, s: str) -> bool:
     *         if len(s) == 1:
     *             return False
     *
     *         stack = []
     *         for c in s:
     *             if c in "({[":
     *                 stack.append(c)
     *             elif c == ')' and (not stack or stack.pop() != '('):
     *                 return False
     *             elif c == ']' and (not stack or stack.pop() != '['):
     *                 return False
     *             elif c == '}' and (not stack or stack.pop() != '{'):
     *                 return False
     *         return not stack
     */

    /**
     * func isValid(s string) bool {
     *     if len(s) == 1 {
     *         return false
     *     }
     *
     *     stack := list.New()
     *     bracketPairs := map[rune]rune{
     *         ')':'(',
     *         '}':'{',
     *         ']':'[',
     *     }
     *
     *     for _, c := range s {
     *         switch c {
     *         case '(', '{', '[':
     *             stack.PushBack(c)
     *         case ')', '}', ']':
     *             if stack.Len() == 0 || stack.Back().Value != bracketPairs[c] {
     *                 return false
     *             }
     *             stack.Remove(stack.Back())
     *         }
     *     }
     *     return stack.Len() == 0
     * }
     */
}
