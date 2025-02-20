// Question: https://leetcode.com/problems/min-stack/description/

class MinStack {
    private Stack<Pair> stack;
    private int minimum = 0;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            minimum = val;
        } else {
            minimum = Math.min(stack.peek().getMinimum(), val);
        }
        stack.push(new Pair(val, minimum));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getElement();
    }

    public int getMin() {
        return stack.peek().getMinimum();
    }
}

class Pair {
    private int element;
    private int minimum;

    public Pair(int element, int minimum) {
        this.element = element;
        this.minimum = minimum;
    }

    public int getElement() {
        return element;
    }

    public int getMinimum() {
        return minimum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */