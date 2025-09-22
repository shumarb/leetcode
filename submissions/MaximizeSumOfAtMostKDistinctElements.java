// Question: https://leetcode.com/problems/maximize-sum-of-at-most-k-distinct-elements/description/

class MaximizeSumOfAtMostKDistinctElements {
    public int[] maxKDistinct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        boolean isTest = false;
        int[] result = null;
        int i = 0;

        Arrays.sort(nums);
        for (i = nums.length - 1; i >= 0; i--) {
            int element = nums[i];
            if (!set.contains(element)) {
                set.add(element);
                minHeap.add(element);
                if (minHeap.size() == k) {
                    break;
                }
            }
        }

        i = minHeap.size() - 1;
        result = new int[minHeap.size()];
        while (!minHeap.isEmpty()) {
            result[i--] = minHeap.poll();
        }
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nmin heap: " + minHeap);
            System.out.println("set: " + set + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}