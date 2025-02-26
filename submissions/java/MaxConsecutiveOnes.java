// Question: https://leetcode.com/problems/max-consecutive-ones/description/

class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int currentStreak = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentStreak++;
            } else {
                maxLength = Math.max(currentStreak, maxLength);
                currentStreak = 0;
            }
        }

        return Math.max(maxLength, currentStreak);
    }
}