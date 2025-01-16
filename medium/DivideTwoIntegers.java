// Question: https://leetcode.com/problems/divide-two-integers/description/

import java.math.BigInteger;

class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean t = false;
        BigInteger dividendB = new BigInteger(String.valueOf(dividend));
        BigInteger divisorB = new BigInteger(String.valueOf(divisor));
        long quotient = dividendB.divide(divisorB).longValue();

        if (t) {
            System.out.println("dividendB: " + dividendB + ", divisor: " + divisorB);
            System.out.println("quotient: " + quotient);
        }
        if (quotient < (long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (quotient > (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) quotient;
    }
}