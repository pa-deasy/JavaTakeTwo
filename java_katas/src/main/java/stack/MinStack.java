package stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> values;
    private Stack<Integer> minimums;

    public MinStack() {
        this.values = new Stack<>();
        this.minimums = new Stack<>();
    }

    public void push(int element) {
        this.values.push(element);
        int minimum = minimums.isEmpty() ? element : Math.min(element, min());
        this.minimums.push(minimum);
    }

    public int peek() {
        return this.values.peek();
    }

    public int pop() {
        this.minimums.pop();
        return this.values.pop();
    }

    public int min() {
        return this.minimums.peek();
    }
}
