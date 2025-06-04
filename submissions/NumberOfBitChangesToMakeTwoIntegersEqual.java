// Question: https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/description/

class NumberOfBitChangesToMakeTwoIntegersEqual {
    public int minChanges(int n, int k) {
        if (n == k) {
            return 0;
        }

        StringBuilder nBinary = new StringBuilder(Integer.toBinaryString(n));
        StringBuilder kBinary = new StringBuilder(Integer.toBinaryString(k));
        boolean isTest = false;
        int count = 0;

        while (nBinary.length() < kBinary.length()) {
            nBinary.insert(0, '0');
        }
        while (kBinary.length() < nBinary.length()) {
            kBinary.insert(0, '0');
        }
        if (isTest) {
            System.out.println("n: " + n + " --> nBinary: " + nBinary);
            System.out.println("k: " + k + " --> kBinary: " + kBinary);
            System.out.println("----------------------------------------------------------");
        }

        int i = nBinary.length() - 1;
        while (i >= 0) {
            char nBit = nBinary.charAt(i);
            char kBit = kBinary.charAt(i);
            if (nBit == '1' && kBit == '0') {
                count++;
                nBinary.setCharAt(i, '0');
            }
            i--;
        }
        if (isTest) {
            System.out.println("n: " + n + " --> nBinary: " + nBinary);
            System.out.println("k: " + k + " --> kBinary: " + kBinary);
            System.out.println("----------------------------------------------------------");
        }

        return nBinary.toString().equals(kBinary.toString()) ? count : -1;
    }
}