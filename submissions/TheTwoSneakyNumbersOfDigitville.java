// Question: https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/description/

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        boolean isTest = false;
        int[] result = new int[2];
        int maximum = 0;

        for (int number: nums) {
            maximum = Math.max(number, maximum);
        }
        int i = 0;
        int[] numberFrequency = new int[maximum + 1];
        for (int number: nums) {
            numberFrequency[number]++;
            if (numberFrequency[number] == 2) {
                result[i++] = number;
            }
            if (i == 2) {
                break;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("numberFrequency: " + Arrays.toString(numberFrequency));
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}