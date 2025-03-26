// Question: https://leetcode.com/problems/design-a-stack-with-increment-operation/description/

class CustomStack {
    private boolean isTest = false;
    private int[] stack;
    private int currentSize;
    private int maxSize;
    private int topIndex;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.topIndex = -1;
        this.stack = new int[maxSize];
        Arrays.fill(stack, -1);
    }

    public void push(int x) {
        if (isTest) {
            System.out.println("push | x: " + x);
            display("before | currentSize: " + currentSize + ", topIndex: " + topIndex);
        }
        if (currentSize < maxSize) {
            stack[++topIndex] = x;
            currentSize++;
        }
        if (isTest) {
            display("after | currentSize: " + currentSize + ", topIndex: " + topIndex);
            display();
        }
    }

    public int pop() {
        if (isTest) {
            System.out.println("pop");
            display("before | currentSize: " + currentSize + ", topIndex: " + topIndex);
        }
        if (currentSize == 0) {
            if (isTest) {
                System.out.println("empty stack, return -1");
            }
            return -1;
        }
        int topElement = stack[topIndex];
        currentSize--;
        stack[topIndex--] = -1;
        if (isTest) {
            display("after | currentSize: " + currentSize + ", topIndex: " + topIndex);
            System.out.println("return top element: " + topElement);
        }

        return topElement;
    }

    public void increment(int k, int val) {
        if (stack.length > 0) {
            if (isTest) {
                System.out.println("increment | k: " + k + ", val: " + val);
                display("before | currentSize: " + currentSize + ", topIndex: " + topIndex);
            }
            for (int i = 0; i < Math.min(currentSize, k); i++) {
                stack[i] += val;
            }
            if (isTest) {
                System.out.println("increment | k: " + k + ", val: " + val);
                display("after | currentSize: " + currentSize + ", topIndex: " + topIndex);
            }
        }
    }

    private void display(String sentence) {
        System.out.println(sentence);
        System.out.println(" * stack: " + Arrays.toString(stack));
    }

    private void display() {
        System.out.println("-------------------------------------------------------------");
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */