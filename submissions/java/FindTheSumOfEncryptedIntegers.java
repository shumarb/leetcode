// Question: https://leetcode.com/problems/find-the-sum-of-encrypted-integers/description/

class FindTheSumOfEncryptedIntegers {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = encrypt(nums[i]);
        }
        for (int number: nums) {
            sum += number;
        }
        return sum;
    }

    private int encrypt(int number) {
        int count = 0;
        int largestDigit = Integer.MIN_VALUE;

        while (number != 0) {
            count++;
            largestDigit = Math.max(largestDigit, number % 10);
            number /= 10;
        }
        while (count > 0) {
            number *= 10;
            number += largestDigit;
            count--;
        }

        return number;
    }
}