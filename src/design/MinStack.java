package design;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(10);
        minStack.push(3);
        minStack.push(15);
        minStack.push(1);
        minStack.pop();
    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    void push(int val) {
        stack.push(val);
        if (minStack.empty()) minStack.push(val);
        else if (minStack.peek() >= val) minStack.push(val);
    }

    void pop() {
        int popped = stack.pop();
        if (!minStack.isEmpty() && popped == minStack.peek())
            minStack.pop();
    }

    int getMin() {
        return minStack.peek();
    }

    int top() {
        return stack.peek();
    }
}
