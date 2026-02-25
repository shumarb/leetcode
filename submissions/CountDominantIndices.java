// Question: https://leetcode.com/problems/count-dominant-indices/description/

class CountDominantIndices {
    public int dominantIndices(int[] nums) {
        boolean isTest = false;
        double sum = 0;
        double count = 0;
        int n = nums.length;
        int result = 0;

        // 1. Edge case: single element.
        if (n == 1) {
            return result;
        }

        for (int e: nums) {
            sum += e;
        }
        for (int i = 0; i < n - 1; i++) {
            double current = nums[i];
            double average = sum / (n - count);
            count++;
            sum -= current;

            if (isTest) {
                System.out.println("i: " + i + "\n * current: " + current + "\n * average from indices [" + (i + 1) + ", " + (n - 1) + "]: " + average);
            }

            if (current > average) {
                if (isTest) {
                    System.out.println(" ** dominant");
                }
                result++;
            }
            if (isTest) {
                System.out.println("---------------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}