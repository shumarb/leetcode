// Question: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/

class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public int missingInteger(int[] nums) {
        boolean[] isPresent = new boolean[2502];
        int result = nums[0];

        for (int e: nums) {
            isPresent[e] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 1 + nums[i - 1]) {
                break;
            }

            result += nums[i];
        }
        while (isPresent[result]) {
            result++;
        }

        return result;
    }
}
