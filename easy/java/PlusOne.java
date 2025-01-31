// Question: https://leetcode.com/problems/plus-one/description/

import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {
        boolean isTest = false;
        int[] result;
        StringBuilder digitsSb = new StringBuilder();

        for (int digit: digits) {
            digitsSb.append(Character.forDigit(digit, 10));
        }
        BigInteger digitsBI = new BigInteger(digitsSb.toString());
        if (isTest) {
            System.out.println("digits: " + Arrays.toString(digits) + "\ndigitsSb: " + digitsSb + "\ndigitsBI: " + digitsBI);
        }

        BigInteger updatedDigitsBI = digitsBI.add(new BigInteger("1"));
        if (isTest) {
            System.out.println("updatedDigitsBI: " + updatedDigitsBI);
        }

        String updatedDigitsBIString = updatedDigitsBI.toString();
        if (isTest) {
            System.out.println("updatedDigitsBIString: " + updatedDigitsBIString);
        }

        result = new int[updatedDigitsBIString.length()];
        for (int i = 0; i < updatedDigitsBIString.length(); i++) {
            result[i] = Character.getNumericValue(updatedDigitsBIString.charAt(i));
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}