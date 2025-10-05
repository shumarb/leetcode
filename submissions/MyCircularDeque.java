// Question: https://leetcode.com/problems/design-circular-deque/description/

class MyCircularDeque {
    private List<Integer> list;
    private int k;

    public MyCircularDeque(int k) {
        list = new ArrayList<>();
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (list.size() == k) {
            return false;
        }

        list.add(0, value);

        return true;
    }

    public boolean insertLast(int value) {
        return list.size() == k ? false : list.add(value);
    }

    public boolean deleteFront() {
        if (list.isEmpty()) {
            return false;
        }

        list.remove(0);
        return true;
    }

    public boolean deleteLast() {
        if (list.isEmpty()) {
            return false;
        }

        list.removeLast();
        return true;
    }

    public int getFront() {
        return list.isEmpty() ? -1 : list.get(0);
    }

    public int getRear() {
        return list.isEmpty() ? -1 : list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */