// Question: https://leetcode.com/problems/random-pick-index/description/

class RandomPickIndex {
    private Random random;
    private int[] nums;

    public Solution(int[] nums) {
        random = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int start = i;
                int end = i + 1;
                while (end < nums.length && nums[end] == target) {
                    end++;
                }

                // 1. Target occurs once in nums
                if (start + 1 == end) {
                    return start;
                }

                return random.nextInt(start, end);
            }
        }

        return -1; // dummy value.
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */