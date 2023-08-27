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

    /**
     *      def evalRPN(self, tokens: List[str]) -> int:
     *         stack = []
     *         for token in tokens:
     *             if token == "+":
     *                 stack.append(stack.pop() + stack.pop())
     *             elif token == "-":
     *                 b = stack.pop()
     *                 a = stack.pop()
     *                 stack.append(a - b)
     *             elif token == "*":
     *                 stack.append(stack.pop() * stack.pop())
     *             elif token == "/":
     *                 b = stack.pop()
     *                 a = stack.pop()
     *                 stack.append(int(float(a) / b))
     *             else:
     *                 stack.append(int(token))
     *
     *         return stack.pop()
     */

    /**
     * func evalRPN(tokens []string) int {
     *     stack := make([]int, 0)
     *     var a, b int
     *     for _, token := range tokens {
     *         switch token {
     *             case "+":
     *                 b = stack[len(stack) - 1]
     *                 stack = stack[:len(stack) - 1]
     *                 a = stack[len(stack) - 1]
     *                 stack = stack[:len(stack) - 1]
     *                 stack = append(stack, a + b)
     *             case "-":
     *                 b = stack[len(stack) - 1]
     *                 stack = stack[:len(stack) - 1]
     *                 a = stack[len(stack) - 1]
     *                 stack = stack[:len(stack) - 1]
     *                 stack = append(stack, a - b)
     *             case "*":
     *                 b = stack[len(stack) - 1]
     *                 stack = stack[:len(stack) - 1]
     *                 a = stack[len(stack) - 1]
     *                 stack = stack[:len(stack) - 1]
     *                 stack = append(stack, a * b)
     *             case "/":
     *                 b = stack[len(stack) - 1]
     *                 stack = stack[:len(stack) - 1]
     *                 a = stack[len(stack) - 1]
     *                 stack = stack[:len(stack) - 1]
     *                 stack = append(stack, a / b)
     *             default:
     *                 num, _ := strconv.Atoi(token)
     *                 stack = append(stack, num)
     *         }
     *     }
     *     return stack[0];
     * }
     */
}
