// Question: https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/

class MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        long score = 0;
        boolean isTest = false;

        for (int number: nums) {
            maxHeap.offer((long) number);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + ", k: " + k + "\nmaxHeap: " + maxHeap);
        }

        for (int i = 0; i < k; i++) {
            long maximum = maxHeap.poll();
            score += maximum;
            maxHeap.offer((long) Math.ceil((double) maximum / 3.0));
        }

        return score;
    }
}