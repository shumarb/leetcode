// Question: https://leetcode.com/problems/sum-of-good-numbers/description/

class SumOfGoodNumbers {
    public int sumOfGoodNumbers(int[] nums, int k) {
        boolean isTest = false;
        int len = nums.length;
        int sumOfGoodNumbers = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nk: " + k);
            System.out.println("----------------------------------------");
        }
        for (int i = 0; i < len; i++) {
            if ((i - k >= 0 && nums[i] <= nums[i - k]) || (i + k < len && nums[i] <= nums[i + k])) {
                continue;
            }

            sumOfGoodNumbers += nums[i];
            if (isTest) {
                System.out.println(" * counted: " + nums[i] + " | index: " + i);
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------");
            System.out.println("sumOfGoodNumbers: " + sumOfGoodNumbers);
        }

        return sumOfGoodNumbers;
    }
}