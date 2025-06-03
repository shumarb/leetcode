// Question: https://leetcode.com/problems/find-the-maximum-divisibility-score/description/

class FindTheMaximumDivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int maxDivScore = Integer.MAX_VALUE;

        for (int divisor: divisors) {
            int count = 0;
            for (int number: nums) {
                if (number % divisor == 0) {
                    count++;
                }
            }
            map.put(divisor, count);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\ndivisors: " + Arrays.toString(divisors) + "\nmap: " + map);
        }

        int maxFrequency = -1;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > maxFrequency || entry.getValue() == maxFrequency && entry.getKey() < maxDivScore) {
                maxDivScore = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        if (isTest) {
            System.out.println("maxDivScore: " + maxDivScore);
        }

        return maxDivScore == Integer.MAX_VALUE ? 0 : maxDivScore;
    }
}