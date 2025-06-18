// Question: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/

class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        boolean isTest = false;
        int len = s.length();
        char[] bits = s.toCharArray();
        char[] changeOneBits = new char[len];
        char[] changeZeroBits = new char[len];

        changeOneBits[0] = '1';
        changeZeroBits[0] = '0';
        for (int i = 1; i < len; i++) {
            if (changeOneBits[i - 1] == '1') {
                changeOneBits[i] = '0';
            } else {
                changeOneBits[i] = '1';
            }
            if (changeZeroBits[i - 1] == '1') {
                changeZeroBits[i] = '0';
            } else {
                changeZeroBits[i] = '1';
            }
        }
        if (isTest) {
            System.out.println("s: " + s);
            System.out.println("bits:           " + Arrays.toString(bits));
        }

        int countChangeOnes = 0;
        int countChangeZeros = 0;
        for (int i = 0; i < len; i++) {
            if (bits[i] != changeOneBits[i]) {
                countChangeOnes++;
            }
            if (bits[i] != changeZeroBits[i]) {
                countChangeZeros++;
            }
        }
        if (isTest) {
            System.out.println("changeOneBits:  " + Arrays.toString(changeOneBits));
            System.out.println("changeZeroBits: " + Arrays.toString(changeZeroBits));
            System.out.println("------------------------------------------------");
            System.out.println("countChangeOnes: " + countChangeOnes);
            System.out.println("countChangeZeros: " + countChangeZeros);
        }

        return Math.min(countChangeOnes, countChangeZeros);
    }
}