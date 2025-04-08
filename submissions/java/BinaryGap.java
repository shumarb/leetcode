// Question: https://leetcode.com/problems/binary-gap/description/

class BinaryGap {
    public int binaryGap(int n) {
        // 1. No maximum gap for numbers whose binary representation is of length 2.
        if (n <= 2) {
            return 0;
        }

        String nBinary = Integer.toBinaryString(n);
        boolean isTest = false;
        int lastOnePosition = -1;
        int maximumGap = 0;

        if (isTest) {
            System.out.println("n: " + n + "\nnBinary: " + nBinary);
        }

        for (int i = 0; i < nBinary.length(); i++) {
            if (nBinary.charAt(i) == '1') {
                if (lastOnePosition == -1) {
                    lastOnePosition = i;
                } else {
                    maximumGap = Math.max(maximumGap, i - lastOnePosition);
                    lastOnePosition = i;
                }
            }
        }

        return maximumGap;
    }
}