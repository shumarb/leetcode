// Question: https://leetcode.com/problems/find-the-maximum-divisibility-score/description/

class FindTheMaximumDivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        boolean isTest = false;
        int maxFrequency = 0;
        int result = Integer.MAX_VALUE;
        int[] divScores = new int[divisors.length];

        for (int i = 0; i < divisors.length; i++) {
            for (int number: nums) {
                if (number % divisors[i] == 0) {
                    divScores[i]++;
                    maxFrequency = Math.max(divScores[i], maxFrequency);
                }
            }
        }
        for (int i = 0; i < divScores.length; i++) {
            int divScore = divScores[i];
            if (maxFrequency == divScores[i] && divisors[i] < result) {
                result = divisors[i];
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("divisors: " + Arrays.toString(divisors));
            System.out.println("divScores: " + Arrays.toString(divScores));
            System.out.println("result: " + result);
        }

        return result;
    }
}