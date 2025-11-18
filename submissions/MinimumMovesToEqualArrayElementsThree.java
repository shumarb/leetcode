// Question: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/description/

class MinimumMovesToEqualArrayElementsThree {
    public int minMoves(int[] nums) {
        // 1. Edge case: Nums has 1 element.
        if (nums.length == 1) {
            return 0;
        }

        int largest = nums[0];
        int result = 0;

        for (int i = 1; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }
        for (int element: nums) {
            if (element == largest) {
                continue;
            }
            result += (largest - element);
        }

        return result;
    }
}