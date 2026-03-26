// Question: https://leetcode.com/problems/reverse-bits/description/

class ReverseBits {
    public int reverseBits(int n) {
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(n));
        boolean isTest = false;
        double result = 0;
        int power = 0;

        while (binary.length() < 32) {
            binary.insert(0, '0');
        }
        if (isTest) {
            System.out.println("binary: " + binary);
        }

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                result += Math.pow(2.0, power);
            }
            power++;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return (int) result;
    }
}
