// Question: https://leetcode.com/problems/min-stack/description/

class MinStack {
    private Stack<int[]> stack;
    private int minimum = 0;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        /**
         1.  If stack is empty, the first value in stack is the minimum.
         2.  If stack is not empty, retrieve minimum value in stack
         by checking minimum value after insertion of latest element
         before current element.
         */
        minimum = stack.isEmpty() ? val : Math.min(stack.peek()[1], val);
        stack.push(new int[]{val, minimum});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
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