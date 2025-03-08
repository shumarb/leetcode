// Question: https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/description/

class FindTheXOROfNumbersWhichAppearTwice {
    public int duplicateNumbersXOR(int[] nums) {
        int maximum = nums[0];
        boolean isTest = false;

        for (int number: nums) {
            maximum = Math.max(number, maximum);
        }
        int[] numberFrequency = new int[maximum + 1];
        for (int number: nums) {
            numberFrequency[number]++;
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nnumberFrequency: " + Arrays.toString(numberFrequency));
        }

        int result = 0;
        for (int i = 1; i < numberFrequency.length; i++) {
            if (numberFrequency[i] == 2) {
                result ^= i;
            }
        }
        return result;
    }
}