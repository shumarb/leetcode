// Question: https://leetcode.com/problems/sum-of-compatible-numbers-in-range-i/description/

class SumOfCompatibleNumbersInRangeI {
    public int sumOfGoodIntegers(int n, int k) {
        boolean isTest = false;
        int result = 0;

        for (int x = 1; x <= (n + k); x++) {
            if (Math.abs(n - x) <= k && ((n & x) == 0)) {
                if (isTest) {
                    System.out.println(" * valid: " + x);
                }
                result += x;
            }
        }

        return result;
    }
}
