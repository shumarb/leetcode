// Question: https://leetcode.com/problems/min-stack/description/

class MinStack {
    private Stack<int[]> stack;
    private int minimum = 0;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        /**
         1. The stack contains integer arrays of size 2:
         - first element (at index 0) is val
         - second element (at index 1) represents the minimum element in the stack after inserting val.

         2.  If stack is empty, val is the first value to be inserted in the stack, so set it as the minimum.
         3.  If stack is not empty, retrieve minimum value in stack (second element of top-most entry),
         comparing it with val, followed by inserting val and minimum element in the stack so far.
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