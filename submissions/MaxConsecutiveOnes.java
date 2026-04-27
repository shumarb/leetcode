// Question: https://leetcode.com/problems/max-consecutive-ones/description/

class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int result = 0;

        for (int e: nums) {
            if (e == 1) {
                current++;
            } else {
                result = Math.max(current, result);
                current = 0;
            }
        }

        return Math.max(current, result);
    }
}
