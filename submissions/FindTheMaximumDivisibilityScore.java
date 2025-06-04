// Question: https://leetcode.com/problems/find-the-maximum-divisibility-score/description/

class FindTheMaximumDivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        boolean isTest = false;
        int maxFrequency = 0;
        int result = Integer.MAX_VALUE;

        for (int divisor: divisors) {
            int currentFrequency = 0;
            for (int number: nums) {
                if (number % divisor == 0) {
                    currentFrequency++;
                }
            }
            if (currentFrequency > maxFrequency) {
                maxFrequency = currentFrequency;
                result = divisor;
            } else if (currentFrequency == maxFrequency && divisor < result) {
                result = divisor;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("divisors: " + Arrays.toString(divisors));
            System.out.println("maxFrequency: " + maxFrequency);
            System.out.println("result: " + result);
        }

        return result;
    }
}