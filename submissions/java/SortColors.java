// Question: https://leetcode.com/problems/sort-colors/description/

class SortColors {
    public void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        boolean isTest = false;

        for (int element: nums) {
            if (element == 0) {
                countZero++;
            }
            if (element == 1) {
                countOne++;
            }
            if (element == 2) {
                countTwo++;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("countZero: " + countZero + "\ncountOne: " + countOne + "\ncountTwo: " + countTwo);
        }

        int index = update(nums, 0, countZero, 0);
        index = update(nums, index, countOne, 1);
        index = update(nums, index, countTwo, 2);

        if (isTest) {
            System.out.println("final nums: " + Arrays.toString(nums));
        }
    }

    private int update(int[] nums, int startIndex, int countValue, int value) {
        int count = 0;
        while (count != countValue) {
            nums[startIndex++] = value;
            count++;
        }
        return startIndex;
    }
}