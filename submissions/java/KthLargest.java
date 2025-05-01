// Question: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int topK = 0;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        topK = k;
        for (int score: nums) {
            minHeap.offer(score);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > topK) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */