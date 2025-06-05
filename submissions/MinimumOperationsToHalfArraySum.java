// Question: https://leetcode.com/problems/minimum-operations-to-halve-array-sum/description/

class MinimumOperationsToHalfArraySum {
    public int halveArray(int[] nums) {
        int count = 0;
        double sum = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        boolean isTest = false;

        for (int element: nums) {
            sum += (double) element;
            maxHeap.offer((double) element);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + ", maxHeap: " + maxHeap);
            System.out.println("--------------------------------------------------------------------------------------------------");
        }

        double halfSum = sum / 2.0;
        while (sum > halfSum) {
            if (isTest) {
                System.out.println("current sum: " + sum + ", halfSum: " + halfSum + ", count: " + count + "\nmaxHeap: " + maxHeap);
                System.out.println("--------------------------------------------------------------------------------------------------");
            }
            count++;
            double removed = maxHeap.poll();
            double incoming = removed / 2.0;
            sum -= (incoming);
            maxHeap.offer(incoming);
        }

        return count;
    }
}