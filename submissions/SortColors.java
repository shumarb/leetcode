// Question: https://leetcode.com/problems/sort-colors/description/

class SortColors {
    public void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        boolean isTest = false;

        for (int element: nums) {
            if (element == 0) {
                countZero++;
            }
            if (element == 1) {
                countOne++;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("countZero: " + countZero + " | countOne: " + countOne + " | countTwo: " + (nums.length - countZero - countOne));
        }

        for (int i = 0; i < nums.length; i++) {
            if (countZero != 0) {
                nums[i] = 0;
                countZero--;
            } else if (countOne != 0) {
                nums[i] = 1;
                countOne--;
            } else {
                nums[i] = 2;
            }
        }
        if (isTest) {
            System.out.println("final nums: " + Arrays.toString(nums));
        }
    }
}