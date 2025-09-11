// Question: https://leetcode.com/problems/maximum-prime-difference/description/

class MaximumPrimeDifference {
    public int maximumPrimeDifference(int[] nums) {
        int firstPrime = 0;
        int lastPrime = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                firstPrime = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (isPrime(nums[i])) {
                lastPrime = i;
                break;
            }
        }

        return lastPrime - firstPrime;
    }

    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        int limit = (int) Math.sqrt(number);
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}