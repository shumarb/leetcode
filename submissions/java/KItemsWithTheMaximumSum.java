// Question: https://leetcode.com/problems/k-items-with-the-maximum-sum/description/

class KItemsWithTheMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int maximumSum = 0;
        boolean isTest = false;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        populate(maxHeap, numOnes, 1);
        populate(maxHeap, numZeros, 0);
        populate(maxHeap, numNegOnes, -1);
        if (isTest) {
            System.out.println("numOnes: " + numOnes + ", numZeros: " + numZeros + ", numNegOnes: " + numNegOnes + ",k: " + k);
            System.out.println("maxHeap: " + maxHeap);
        }

        for (int i = 0; i < k; i++) {
            if (isTest) {
                System.out.println("-------------------------");
                System.out.println("before, maxHeap: " + maxHeap + ", maximumSum: " + maximumSum);
            }
            maximumSum += maxHeap.peek();
            maxHeap.poll();
            if (isTest) {
                System.out.println("after, maxHeap: " + maxHeap + ", maximumSum: " + maximumSum);
            }
        }
        if (isTest) {
            System.out.println("final maximumSum: " + maximumSum);
        }

        return maximumSum;
    }

    private void populate(PriorityQueue<Integer> maxHeap, int count, int number) {
        for (int i = 0; i < count; i++) {
            maxHeap.offer(number);
        }
    }
}