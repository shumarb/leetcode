// Question: https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/description/

class MinimumAmountOfTimeToFillCups {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        boolean isTest = false;
        int time = 0;
        int totalAmount = 0;

        for (int water: amount) {
            maxHeap.offer(water);
            totalAmount += water;
        }

        // 1. Edge case: All cups do not require to be filled.
        if (totalAmount == 0) {
            return 0;
        }

        while (maxHeap.size() > 1) {
            if (isTest) {
                System.out.println(" * time " + time + ", maxHeap: " + maxHeap);
            }

            /**
             2.  Greedily get top 2 cups with highest remainder of water to fill,
                 increment time by 1, and add it to heap if each of its balance - 1 is more than 0.
             */
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            time++;

            if (first - 1 > 0) {
                maxHeap.offer(first - 1);
            }
            if (second - 1 > 0) {
                maxHeap.offer(second - 1);
            }
            if (isTest) {
                System.out.println(" * time " + time + ", maxHeap: " + maxHeap);
                System.out.println("---------------------------------");
            }
        }

        /**
         3.  Max heap has either 0 or 1 element. If it has 1 element,
             increase time by its remainder to find total time required to fill all cups.
         */
        if (isTest) {
            System.out.println(" * time " + time + ", maxHeap: " + maxHeap);
        }
        if (!maxHeap.isEmpty()) {
            time += maxHeap.poll();
        }
        if (isTest) {
            System.out.println(" * time " + time + ", maxHeap: " + maxHeap);
            System.out.println("---------------------------------\ntotal time: " + time);
        }

        return time;
    }
}