// Question: https://leetcode.com/problems/design-a-stack-with-increment-operation/description/

class CustomStack {
    private List<Integer> stack;
    private int maxSize;
    private boolean isTest = false;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new ArrayList<>(maxSize);
    }

    public void push(int x) {
        if (isTest) {
            System.out.println("push | " + x);
            display("before | ");
        }
        if (stack == null) {
            stack = new ArrayList<>(maxSize);
        }
        if (stack.size() < maxSize) {
            stack.add(x);
        }
        if (isTest) {
            display("after | ");
            display();
        }
    }

    public int pop() {
        if (isTest) {
            System.out.println("pop");
            display("before | ");
        }
        if (stack.isEmpty()) {
            if (isTest) {
                System.out.println(" * return: -1");
                display("after | ");
                display();
            }
            return -1;
        } else {
            int topElement = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            if (isTest) {
                System.out.println(" * return: " + topElement);
                display("after | ");
                display();
            }
            return topElement;
        }
    }

    public void increment(int k, int val) {
        if (isTest) {
            System.out.println("increment | k: " + k + ", val: " + val);
            display("before | ");
        }
        if (!stack.isEmpty()) {
            if (stack.size() < k) {
                for (int i = 0; i < stack.size(); i++) {
                    stack.set(i, stack.get(i) + val);
                }
            } else {
                for (int i = 0; i < k; i++) {
                    stack.set(i, stack.get(i) + val);
                }
            }
        }
        if (isTest) {
            display("after | ");
            display();
        }
    }

    private void display() {
        System.out.println("----------------------------------------");
    }

    private void display(String sentence) {
        System.out.println(sentence + "stack: " + stack);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */