// Question: https://leetcode.com/problems/design-linked-list/description/

class MyLinkedList {
    private List<Integer> list;
    private boolean isTest = false;

    public MyLinkedList() {
        list = new ArrayList<>();
    }

    public int get(int index) {
        if (list.isEmpty() || index >= list.size()) {
            return -1;
        }
        if (isTest) {
            System.out.println("get | index: " + index);
            display();
        }
        return list.get(index);
    }

    public void addAtHead(int val) {
        list.add(0, val);
        if (isTest) {
            System.out.println("add at head | val: " + val);
            display();
        }
    }

    public void addAtTail(int val) {
        list.add(val);
        if (isTest) {
            System.out.println("add at tail | val: " + val);
            display();
        }
    }

    public void addAtIndex(int index, int val) {
        if (isTest) {
            System.out.println("add at index | index: " + index + ", val: " + val);
        }
        if (index < list.size()) {
            list.add(index, val);
            if (isTest) {
                display();
            }
        }

        if (index == list.size()) {
            list.add(val);
            if (isTest) {
                display();
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (isTest) {
            System.out.println("delete at index | index: " + index);
            display();
        }
        if (!list.isEmpty() || index < list.size()) {
            List newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i != index) {
                    newList.add(list.get(i));
                }
            }
            list = newList;
        }
    }

    private void display() {
        if (!list.isEmpty()) {
            System.out.print("list: ");
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + " --> ");
            }
            System.out.println(list.get(list.size() - 1));
            System.out.println("----------------------------------------------");
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */