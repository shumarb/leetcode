// Question: https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i/description/

class CountPairsThatFormACompleteDayOne {
    public int countCompleteDayPairs(int[] hours) {
        boolean isTest = false;
        long[] remainders = new long[24];
        long result = 0;

        for (int hour: hours) {
            remainders[hour % 24]++;
        }

        // 1. Form pairs amongst groups that are multiples of 24 (0, 12).
        result += remainders[0] * (remainders[0] - 1) / 2;
        result += remainders[12] * (remainders[12] - 1) / 2;

        // 2. Form pairs amongst remainders not multiple of 24.
        for (int i = 1; i < 12; i++) {
            result += remainders[i] * remainders[24 - i];
        }

        if (isTest) {
            System.out.println("remainders: " + Arrays.toString(remainders) + "\nresult: " + result);
        }

        return (int) result;
    }
}