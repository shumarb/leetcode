// Question: https://leetcode.com/problems/sliding-window-maximum/description/

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
        );
        boolean isTest = false;
        int j = 0;
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[] {nums[i], i});
            if (i >= k - 1) {
                while (maxHeap.peek()[1] <= i - k) {
                    maxHeap.poll();
                }
                if (isTest) {
                    display(maxHeap);
                }
                result[j++] = maxHeap.peek()[0];
            }
        }
        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums));
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private void display(PriorityQueue<int[]> maxHeap) {
        System.out.println("max heap:");
        for (int[] entry: maxHeap) {
            System.out.println(Arrays.toString(entry));
        }
        System.out.println("-----------------------------------------------");
    }
}