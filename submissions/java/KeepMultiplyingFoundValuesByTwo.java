// Question: https://leetcode.com/problems/keep-multiplying-found-values-by-two/description/

class KeepMultiplyingFoundValuesByTwo {
    public int findFinalValue(int[] nums, int original) {
        while (isPresent(nums, original)) {
            original *= 2;
        }
        return original;
    }

    private boolean isPresent(int[] nums, int target) {
        for (int number: nums) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }
}