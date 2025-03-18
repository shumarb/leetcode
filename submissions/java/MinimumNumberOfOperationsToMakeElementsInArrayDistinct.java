// Question: https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/

class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    public int minimumOperations(int[] nums) {
        if (isDistinct(nums, 0)) {
            return 0;
        }

        int result = 0;
        int i = 0;
        while (i < nums.length && !isDistinct(nums, i)) {
            i += 3;
            result++;
        }

        return result;
    }

    private boolean isDistinct(int[] nums, int i) {
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (set.contains(nums[j])) {
                return false;
            }
            set.add(nums[j]);
        }

        return true;
    }
}