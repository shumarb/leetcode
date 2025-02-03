// Question: https://leetcode.com/problems/binary-number-with-alternating-bits/description/

class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        if (n == 1) {
            return true;
        }
        StringBuilder nBinary = new StringBuilder();
        boolean isTest = false;

        while (n != 0) {
            if (n % 2 == 0) {
                nBinary.insert(0, '0');
            } else {
                nBinary.insert(0, '1');
            }
            n /= 2;
        }
        if (isTest) {
            System.out.println("n: " + n + " | nBinary: " + nBinary);
        }

        String nBinaryString = nBinary.toString();

        if (isSameBits(nBinaryString)) {
            return false;
        }

        for (int i = 1; i < nBinaryString.length() - 1; i++) {
            char bit = nBinaryString.charAt(i);
            if (!isValid(nBinaryString, i, bit)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(String nBinaryString, int i, char bit) {
        return nBinaryString.charAt(i - 1) != bit && nBinaryString.charAt(i + 1) != bit;
    }

    private boolean isSameBits(String nBinaryString) {
        int num0 = 0;
        int num1 = 0;
        for (char bit: nBinaryString.toCharArray()) {
            if (bit == '1') {
                num1++;
            }
            if (bit == '0') {
                num0++;
            }
        }
        return num0 == 0 || num1 == 0;
    }
}