// Question: https://leetcode.com/problems/sort-an-array/description/

class SortAnArray {
    public int[] sortArray(int[] nums) {
        // 1. Edge case: Array contains single element, hence it is sorted.
        if (nums.length == 1) {
            return nums;
        }

        int[] integerFrequency = new int[100001];
        for (int integer: nums) {
            integerFrequency[integer + 50000]++;
        }

        int j = 0;
        for (int i = 0; i < integerFrequency.length; i++) {
            while (integerFrequency[i] > 0) {
                nums[j++] = i - 50000;
                integerFrequency[i]--;
            }
        }

        return nums;
    }
}