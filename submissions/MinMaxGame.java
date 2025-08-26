// Question: https://leetcode.com/problems/min-max-game/description/

class MinMaxGame {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                int first = nums[2 * i];
                int second = nums[2 * i + 1];
                nums[i] = (i % 2 == 0) ? Math.min(first, second) : Math.max(first, second);
            }
            n /= 2;
        }

        return nums[0];
    }
}