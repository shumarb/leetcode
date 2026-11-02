// Question: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/

class MinimumMovesToEqualArrayElementsTwo {
    public int minMoves2(int[] nums) {
        boolean isTest = false;
        int median;
        int n = nums.length;
        int result = 0;

        // 1. Edge case: nums has only 1 element.
        if (n == 1) {
            return 0;
        }

        Arrays.sort(nums);
        median = (n % 2 == 0) ? nums[n / 2 - 1] : nums[n / 2];
        for (int element: nums) {
            result += Math.abs(element - median);
        }
        if (isTest) {
            System.out.println("median: " + median + "\nresult: " + result);
        }

        return result;
    }
}