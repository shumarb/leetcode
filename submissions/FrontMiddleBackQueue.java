// Question: https://leetcode.com/problems/design-front-middle-back-queue/description/

class FrontMiddleBackQueue {
    private List<Integer> queue;
    private boolean isTest;

    public FrontMiddleBackQueue() {
        isTest = false;
        queue = new ArrayList<>();
    }

    public void pushFront(int val) {
        if (isTest) {
            display("push front. val: " + val + "\nbefore: ");
        }
        queue.add(0, val);
        if (isTest) {
            display("after: ");
            System.out.println("--------------------------------");
        }
    }

    public void pushMiddle(int val) {
        if (isTest) {
            display("push middle. val: " + val + "\nbefore: ");
        }
        queue.add(queue.size() / 2, val);
        if (isTest) {
            display("after: ");
            System.out.println("--------------------------------");
        }
    }

    public void pushBack(int val) {
        if (isTest) {
            display("push back. val: " + val + "\nbefore: ");
        }
        queue.add(val);
        if (isTest) {
            display("after: ");
            System.out.println("--------------------------------");
        }
    }

    public int popFront() {
        if (isTest) {
            display("pop front. \nbefore: ");
        }

        if (queue.isEmpty()) {
            return -1;
        }

        List<Integer> updated = new ArrayList<>();
        int element = queue.get(0);
        for (int i = 1; i < queue.size(); i++) {
            updated.add(queue.get(i));
        }
        queue = updated;

        if (isTest) {
            display("after: ");
            System.out.println("--------------------------------");
        }

        return element;
    }

    public int popMiddle() {
        if (isTest) {
            display("pop middle. \nbefore: ");
        }

        if (queue.isEmpty()) {
            return -1;
        }

        List<Integer> updated = new ArrayList<>();
        int element;
        int middleIndex;
        if (queue.size() % 2 == 0) {
            middleIndex = queue.size() / 2 - 1;
        } else {
            middleIndex = queue.size() / 2;
        }
        element = queue.get(middleIndex);

        for (int i = 0; i < queue.size(); i++) {
            if (i == middleIndex) {
                continue;
            }
            updated.add(queue.get(i));
        }

        queue = updated;
        if (isTest) {
            display("element to return: " + element + "\nafter: ");
            System.out.println("--------------------------------");
        }

        return element;
    }

    public int popBack() {
        if (isTest) {
            display("before: ");
        }

        if (queue.size() == 0) {
            return -1;
        }

        int element = queue.get(queue.size() - 1);
        List<Integer> updated = new ArrayList<>();
        for (int i = 0; i < queue.size() - 1; i++) {
            updated.add(queue.get(i));
        }

        queue = updated;
        if (isTest) {
            display("element to return: " + element + "\nafter: ");
            System.out.println("--------------------------------");
        }

        return element;
    }

    private void display(String sentence) {
        System.out.println(sentence + queue);
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */