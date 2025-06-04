// Question: https://leetcode.com/problems/add-binary/description/

import java.math.BigInteger;

class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;
        int carry = 0;

        while (aPointer >= 0 || bPointer >= 0 || carry != 0) {
            int sum = carry;
            if (aPointer >= 0) {
                // Convert char char '1' to integer 1 or char '0' to integer 0
                sum += a.charAt(aPointer--) - '0';
            }

            if (bPointer >= 0) {
                // Convert char char '1' to integer 1 or char '0' to integer 0
                sum += b.charAt(bPointer--) - '0';
            }

            result.append(sum % 2);
            carry = sum / 2;
        }
        result.reverse();
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result.toString();
    }
}