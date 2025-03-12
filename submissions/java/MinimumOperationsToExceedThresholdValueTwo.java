// Question: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/

class MinimumOperationsToExceedThresholdValueTwo {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int count = 0;
        boolean isTest = false;
        for (int number: nums) {
            minHeap.offer((long) number);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + ", k: " + k + "\nminHeap: " + minHeap);
            System.out.println("--------------------------------------------------------------------------");
        }

        while (minHeap.size() >= 2 && minHeap.peek() < k) {
            if (isTest) {
                System.out.println("start | minHeap: " + minHeap + ", count: " + count);
            }
            long minimum = minHeap.poll();
            long secondMinimum = minHeap.poll();
            long toAdd = 2 * minimum + secondMinimum;
            if (isTest) {
                System.out.println(" * minimum: " + minimum + ", secondMinimum: " + secondMinimum + ", toAdd: " + toAdd);
            }
            minHeap.offer(toAdd);
            count++;
            if (isTest) {
                System.out.println("end | minHeap: " + minHeap + ", count: " + count);
                System.out.println("--------------------------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("minHeap: " + minHeap + "\ncount: " + count);
        }

        return count;
    }
}