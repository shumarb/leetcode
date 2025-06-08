// Question: https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/

class FindXSumOfAllKLongSubarraysOne {
    public int[] findXSum(int[] nums, int k, int x) {
        boolean isTest = false;
        int j = 0;
        int largest = nums[0];
        int len = nums.length;
        int[] result = new int[len - k + 1];

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("k: " + k + "\nx: " + x);
            System.out.println("-----------------------------------------------");
        }

        for (int i = 1; i < len; i++) {
            largest = Math.max(largest, nums[i]);
        }
        int[] windowFrequency = new int[largest + 1];
        for (int i = 0; i < k; i++) {
            windowFrequency[nums[i]]++;
        }
        PriorityQueue<int[]> windowHeap = getWindowHeap(windowFrequency, x);
        result[j++] = computeXSum(windowHeap);
        if (isTest) {
            display(windowFrequency);
        }

        for (int i = k; i < len; i++) {
            int remove = nums[i - k];
            int incoming = nums[i];
            windowFrequency[remove]--;
            windowFrequency[incoming]++;
            windowHeap = getWindowHeap(windowFrequency, x);
            result[j++] = computeXSum(windowHeap);
            if (isTest) {
                display(windowFrequency);
            }
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private int computeXSum(PriorityQueue<int[]> windowHeap) {
        int sum = 0;
        while (!windowHeap.isEmpty()) {
            int[] top = windowHeap.poll();
            sum += top[0] * top[1];
        }
        return sum;
    }

    private PriorityQueue<int[]> getWindowHeap(int[] windowFrequency, int x) {
        PriorityQueue<int[]> windowHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1]) == 0
                        ? Integer.compare(a[0], b[0])
                        : Integer.compare(a[1], b[1])
        );
        for (int i = 0; i < windowFrequency.length; i++) {
            if (windowFrequency[i] > 0) {
                windowHeap.offer(new int[] {i, windowFrequency[i]});
            }
            if (windowHeap.size() > x) {
                windowHeap.poll();
            }
        }
        return windowHeap;
    }

    private void display(int[] windowFrequency) {
        System.out.println("windowFrequency: " + Arrays.toString(windowFrequency));
        System.out.println("---------------------------------------------------------------------");
    }
}