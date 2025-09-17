// Question: https://leetcode.com/problems/jump-game/description/

class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maximumIndex = 0;

        for (int i = 0; i < len; i++) {
            if (i > maximumIndex) {
                return false;
            }

            maximumIndex = Math.max(maximumIndex, i + nums[i]);
        }

        return true;
    }
}