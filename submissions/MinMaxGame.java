// Question: https://leetcode.com/problems/min-max-game/description/

class MinMaxGame {
    public int minMaxGame(int[] nums) {
        while (nums.length > 1) {
            int n = nums.length;
            int[] newNums = new int[n / 2];
            for (int i = 0; i < n / 2; i++) {
                int first = nums[2 * i];
                int second = nums[2 * i + 1];
                if (i % 2 == 0) {
                    newNums[i] = Math.min(first, second);
                } else {
                    newNums[i] = Math.max(first, second);
                }
            }
            nums = newNums;
        }

        return nums[0];
    }
}