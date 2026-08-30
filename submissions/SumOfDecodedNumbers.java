// Question: https://leetcode.com/problems/sum-of-decoded-numbers/description/

class SumOfDecodedNumbers {
    private long mod;

    public int sumDecoded(long[] nums) {
        boolean isTest = false;
        long result = 0;
        mod = 1000000007;

        for (long e: nums) {
            long d = e / 10;
            long decodedValue = 0;
            long x = 0;
            long y = 0;
            long width = e % 10;
            char[] digits = Long.toString(d).toCharArray();

            for (int i = 0; i < width; i++) {
                x *= 10;
                x += (long) (digits[i] - '0');
            }
            for (int i = (int) width; i < digits.length; i++) {
                y *= 10;
                y += (long) (digits[i] - '0');
            }

            decodedValue = modPow(x, y);
            if (isTest) {
                System.out.println(" * e: " + e + " | width: " + width + " | d: " + d + " | x: " + x + " | y: " + y + " | decodedValue: " + decodedValue);
            }

            result = (result + decodedValue) % mod;
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------------------------------\nresult: " + result);
        }

        return (int) result;
    }

    private long modPow(long x, long y) {
        long result = 1;

        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % mod;
            }

            x = (x * x) % mod;
            y /= 2;
        }

        return result;
    }
}
