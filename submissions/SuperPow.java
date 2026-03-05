// Question: https://leetcode.com/problems/super-pow/description/

import java.math.BigInteger;

class SuperPow {
    public int superPow(int a, int[] b) {
        BigInteger aValue = new BigInteger(Integer.toString(a));
        BigInteger exponent;
        BigInteger mod = new BigInteger(Integer.toString(1337));
        BigInteger result;
        StringBuilder bSb = new StringBuilder();
        boolean isTest = false;

        for (int digit: b) {
            bSb.append(digit);
        }
        exponent = new BigInteger(bSb.toString());
        aValue = aValue.modPow(exponent, mod);
        if (isTest) {
            System.out.println("aValue: " + aValue + "\nexponent: " + exponent);
        }

        return aValue.intValue();
    }
}