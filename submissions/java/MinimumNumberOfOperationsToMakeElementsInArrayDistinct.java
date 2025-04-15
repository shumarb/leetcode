// Question: https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/

class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    public int minimumOperations(int[] nums) {
        if (isDistinct(nums, 0)) {
            return 0;
        }

        int result = 0;
        int i = 0;
        while (!isDistinct(nums, i) && i < nums.length) {
            i += 3;
            result++;
        }

        return result;
    }

    private boolean isDistinct(int[] nums, int i) {
        boolean[] isNumberPresent = new boolean[101];
        for (int j = i; j < nums.length; j++) {
            if (isNumberPresent[nums[j]]) {
                return false;
            }
            isNumberPresent[nums[j]] = true;
        }

        return true;
    }
}