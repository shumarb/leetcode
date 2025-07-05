// Question: https://leetcode.com/problems/design-front-middle-back-queue/description/

class FrontMiddleBackQueue {
    private LinkedList<Integer> queue;
    private boolean isTest;

    public FrontMiddleBackQueue() {
        queue = new LinkedList<>();
        isTest = false;
    }

    public void pushFront(int val) {
        if (isTest) {
            display("push front.\n * before: ");
        }
        queue.offerFirst(val);
        if (isTest) {
            display(" * after: ");
            System.out.println("-----------------------------------------------");
        }
    }

    public void pushMiddle(int val) {
        if (isTest) {
            display("push middle.\n * before: ");
        }
        queue.add(queue.size() / 2, val);
        if (isTest) {
            display(" * after: ");
            System.out.println("-----------------------------------------------");
        }
    }

    public void pushBack(int val) {
        if (isTest) {
            display("push back.\n * before: ");
        }
        queue.offerLast(val);
        if (isTest) {
            display(" * after: ");
            System.out.println("-----------------------------------------------");
        }
    }

    public int popFront() {
        if (isTest) {
            display("pop front.\n * before: ");
        }
        if (queue.size() == 0) {
            return -1;
        }

        int element = queue.pollFirst();
        if (isTest) {
            display(" * after: ");
            System.out.println(" * element to return: " + element);
            System.out.println("-----------------------------------------------");
        }

        return element;
    }

    public int popMiddle() {
        if (isTest) {
            display("pop middle.\n * before: ");
        }
        if (queue.size() == 0) {
            return -1;
        }

        int element;
        int middleIndex;
        if (queue.size() % 2 == 0) {
            middleIndex = queue.size() / 2 - 1;
        } else {
            middleIndex = queue.size() / 2;
        }
        element = queue.remove(middleIndex);

        if (isTest) {
            display(" * after: ");
            System.out.println(" * element to return: " + element);
            System.out.println("-----------------------------------------------");
        }

        return element;
    }

    public int popBack() {
        if (isTest) {
            display("pop back.\n * before: ");
        }
        if (queue.size() == 0) {
            return -1;
        }

        int element = queue.pollLast();
        if (isTest) {
            display(" * after: ");
            System.out.println(" * element to return: " + element);
            System.out.println("-----------------------------------------------");
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