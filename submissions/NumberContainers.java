// Question: https://leetcode.com/problems/design-a-number-container-system/description/

class NumberContainers {
    private Map<Integer, Integer> indexToNumber;
    private Map<Integer, PriorityQueue<Integer>> numberToIndices;
    private boolean isTest;

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        isTest = false;
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (isTest) {
            System.out.println("------------------------------------");
            System.out.println("change | index: " + index + ", number: " + number);
            display("before");
        }

        indexToNumber.put(index, number);
        PriorityQueue<Integer> value = numberToIndices.get(number);
        if (value == null) {
            value = new PriorityQueue<>();
        }
        value.offer(index);
        numberToIndices.put(number, value);

        if (isTest) {
            display("\nafter");
        }
    }

    public int find(int number) {
        if (isTest) {
            System.out.println("------------------------------------");
            display("find | number: " + number);
        }

        if (!numberToIndices.containsKey(number)) {
            return -1;
        }
        PriorityQueue<Integer> value = numberToIndices.get(number);
        while (!value.isEmpty() && indexToNumber.get(value.peek()) != number) {
            value.poll();
        }

        return value.isEmpty() ? -1 : value.peek();
    }

    private void display(String s) {
        System.out.println(s);
        System.out.println(" * indexToNumber: " + indexToNumber);
        System.out.println(" * numberToIndices:");
        for (Map.Entry<Integer, PriorityQueue<Integer>> e: numberToIndices.entrySet()) {
            System.out.println(" ** " + e.getKey() + " -> " + e.getValue());
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */