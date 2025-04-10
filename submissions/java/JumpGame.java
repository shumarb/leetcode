// Question: https://leetcode.com/problems/jump-game/description/

class JumpGame {
    public boolean canJump(int[] nums) {
        int maximumIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            /**
                 1.  Current index can't be reached
                     and current index is not last element.
             */
            if (i > maximumIndex) {
                return false;
            }

            maximumIndex = Math.max(maximumIndex, i + nums[i]);
        }

        return true;
    }
}