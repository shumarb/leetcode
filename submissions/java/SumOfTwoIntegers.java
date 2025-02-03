// Question: https://leetcode.com/problems/sum-of-two-integers/description/

import java.math.BigInteger;

class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        BigInteger aBi = new BigInteger(String.valueOf(a));
        BigInteger bBi = new BigInteger(String.valueOf(b));
        return aBi.add(bBi).intValue();
    }

}
