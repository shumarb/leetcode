// Question: https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer> ();
        int kLargest = 0;
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

}
