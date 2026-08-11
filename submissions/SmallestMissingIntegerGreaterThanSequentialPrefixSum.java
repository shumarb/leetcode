// Question: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/

class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = nums[0];

        for (int e: nums) {
            set.add(e);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 1 + nums[i - 1]) {
                break;
            }

            result += nums[i];
        }
        while (set.contains(result)) {
            result++;
        }

        return result;
    }
}
