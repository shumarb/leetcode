// Question: https://leetcode.com/problems/add-binary/description/

import java.math.BigInteger;

class AddBinary {
    public String addBinary(String a, String b) {
        BigInteger b1 = new BigInteger(a, 2);
        BigInteger b2 = new BigInteger(b, 2);
        BigInteger sum = b1.add(b2);
        boolean t = false;
        if (t) {
            System.out.println("b1: " + b1 + "\nb2: " + b2 + "\nsum: " + sum + "\nsum in base 2: " + sum.toString(2));
        }
        return sum.toString(2);
    }
}