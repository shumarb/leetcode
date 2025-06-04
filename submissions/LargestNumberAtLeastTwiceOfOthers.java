// Question: https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/

class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int maximum = nums[0];
        int indexOfMaximum = 0;

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (nums[i] > maximum) {
                maximum = current;
                indexOfMaximum = i;
            }
        }

        // 1. Maximum elment is not twice as much as at least one element.
        for (int number: nums) {
            if (number != maximum && maximum < (2 * number)) {
                return -1;
            }
        }

        // 2. Maximum is at twice as much as all other elements.
        return indexOfMaximum;
    }
}