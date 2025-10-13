// Question: https://leetcode.com/problems/shuffle-an-array/description/

class ShuffleAnArray {
    private int[] nums;
    private int n;

    public Solution(int[] nums) {
        n = nums.length;
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums.length == 1) {
            return nums;
        }

        Random random = new Random();
        int[] result = nums.clone();

        for (int i = n - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */