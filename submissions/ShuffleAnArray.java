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
        if (n == 1) {
            return nums;
        }

        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] shuffle = new int[n];

        for (int e: nums) {
            list.add(e);
        }
        Collections.shuffle(list);
        for (int i = 0; i < n; i++) {
            shuffle[i] = list.get(i);
        }

        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */