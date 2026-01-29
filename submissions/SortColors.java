// Question: https://leetcode.com/problems/sort-colors/description/

class SortColors {
    public void sortColors(int[] nums) {
        boolean isTest = false;
        int countOne = 0;
        int countZero = 0;
        int n = nums.length;

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }
        for (int colour: nums) {
            if (colour == 0) {
                countZero++;
            } else if (colour == 1) {
                countOne++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (countZero > 0) {
                nums[i] = 0;
                countZero--;

            } else if (countOne > 0) {
                nums[i] = 1;
                countOne--;

            } else {
                nums[i] = 2;
            }
        }
        if (isTest) {
            System.out.println("after, nums:  " + Arrays.toString(nums));
        }
    }
}