// Question: https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/description/

class CountPairsThatFormACompleteDayTwo {
    public long countCompleteDayPairs(int[] hours) {
        boolean isTest = false;
        long[] remainders = new long[24];
        long result = 0;

        for (int hour: hours) {
            remainders[hour % 24]++;
        }
        // 1. Special case: Count valid pairs of hours divisible by 24, which are 0 & 12.
        result += remainders[0] * (remainders[0] - 1) / 2;
        result += remainders[12] * (remainders[12] - 1) / 2;

        /**
         2. Form pairs from remainders i & (24 - i) for i ranging from [1, 11].
            Iterate from 1 to 11 to ensure no double counting.
         */
        for (int i = 1; i < 12; i++) {
            result += remainders[i] * remainders[24 - i];
        }
        if (isTest) {
            System.out.println("remainders: " + Arrays.toString(remainders) + "\nresult: " + result);
        }

        return result;
    }
}