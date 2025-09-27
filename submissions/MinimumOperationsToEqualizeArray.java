// Question: https://leetcode.com/problems/minimum-operations-to-equalize-array/description/

class MinimumOperationsToEqualizeArray {
    public int minOperations(int[] nums) {
        int element = nums[0];

        for (int number: nums) {
            if (number != element) {
                return 1;
            }
        }

        return 0;
    }
}