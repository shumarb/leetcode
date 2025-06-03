// Question: https://leetcode.com/problems/find-the-maximum-divisibility-score/description/

class FindTheMaximumDivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        boolean isTest = false;
        int maxFrequency = 0;
        int result = Integer.MAX_VALUE;
        int[] frequency = new int[divisors.length];

        for (int i = 0; i < divisors.length; i++) {
            for (int number: nums) {
                if (number % divisors[i] == 0) {
                    frequency[i]++;
                }
            }
        }
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFrequency || (frequency[i] == maxFrequency && divisors[i] < result)) {
                maxFrequency = frequency[i];
                result = divisors[i];
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("divisors: " + Arrays.toString(divisors));
            System.out.println("frequency: " + Arrays.toString(frequency));
            System.out.println("result: " + result);
        }

        return result;
    }
}