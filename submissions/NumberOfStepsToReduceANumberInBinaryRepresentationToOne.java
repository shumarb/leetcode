// Question: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/

import java.math.BigInteger;

class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public int numSteps(String s) {
        BigInteger number = new BigInteger(s, 2);
        boolean isTest = false;
        int result = 0;

        if (isTest) {
            System.out.println("s: " + s + " -> number: " + number);
        }
        while (number.compareTo(BigInteger.ONE) > 0) {
            if (isTest) {
                System.out.println("----------------------------------------------------");
                System.out.println(" * before | number: " + number + ", result: " + result);
            }

            if (number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                number = number.divide(BigInteger.TWO);
            } else {
                number = number.add(BigInteger.ONE);
            }
            result++;
            if (isTest) {
                System.out.println(" * after  | number: " + number + ", result: " + result);
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}