// Question: https://leetcode.com/problems/maximize-pair-strength-using-gcd/description/

class MaximizePairStrengthUsingGcd {
    public long maxPairStrength(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        long result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long first = nums[i];
                long second = nums[j];
                long product = first * second;
                long gcd = computeGcd(first, second);
                long value = product / (gcd * gcd);

                if (isTest) {
                    System.out.println(" * indices: [" + i + ", " + j + "], elements: [" + first + ", " + second + "], product: " + product + ", gcd: " + gcd + ", value: " + value);
                }
                result = Math.max(
                        (first * second) / (gcd * gcd),
                        result
                );
            }
        }

        return result;
    }

    private long computeGcd(long a, long b) {
        return b == 0 ? a : computeGcd(b, a % b);
    }
}
