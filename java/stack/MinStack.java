package stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack();

    public void push(int x) {
        stack.push(x);
        if(minStack.empty()) minStack.push(x);
        else if (minStack.peek() >= x) minStack.push(x);
    }

    public void pop() {
        int popped = stack.pop();
        if(!minStack.empty() && popped == minStack.peek()) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
