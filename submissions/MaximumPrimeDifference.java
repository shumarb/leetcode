// Question: https://leetcode.com/problems/maximum-prime-difference/description/

class MaximumPrimeDifference {
    public int maximumPrimeDifference(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (!isPrime(nums[i])) {
            i++;
        }

        while (!isPrime(nums[j])) {
            j--;
        }

        return j - i;
    }

    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}