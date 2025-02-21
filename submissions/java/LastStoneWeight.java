// Question: https://leetcode.com/problems/last-stone-weight/description/

class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        boolean isTest = false;

        for (int stone: stones) {
            maxHeap.offer(stone);
        }
        if (isTest) {
            System.out.println("stones: " + Arrays.toString(stones) + "\nmaxHeap: " + maxHeap);
            System.out.println("----------------------------------------------------------------");
        }

        while (maxHeap.size() >= 2) {
            if (isTest) {
                System.out.println("maxHeap at start: " + maxHeap);
            }
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x > y) {
                int temp = y;
                y = x;
                x = temp;
            }
            if (isTest) {
                System.out.println("x: " + x + ", y: " + y);
            }
            if (x != y) {
                maxHeap.offer(y - x);
            }
            if (isTest) {
                System.out.println("maxHeap at end: " + maxHeap);
                System.out.println("----------------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final maxHeap: " + maxHeap);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}