// Question: https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/

class FinalArrayStateAfterKMultiplicationOperationsOne {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        boolean isTest = false;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                }
        );

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[] {nums[i], i});
        }
        if (isTest) {
            display(minHeap);
        }

        for (int i = 0; i < k; i++) {
            int[] minimum = minHeap.poll();
            minHeap.offer(new int[] {multiplier * minimum[0], minimum[1]});
            if (isTest) {
                display(minHeap);
            }
        }

        while (!minHeap.isEmpty()) {
            int[] minimum = minHeap.poll();
            nums[minimum[1]] = minimum[0];
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("after nums: " + Arrays.toString(nums));
        }

        return nums;
    }

    private void display(PriorityQueue<int[]> minHeap) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("minHeap: ");
        for (int[] pair: minHeap) {
            System.out.println(" * (" + pair[0] + ", i: " + pair[1] + ")");
        }
    }
}