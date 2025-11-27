// Question: https://leetcode.com/problems/minimum-number-of-flips-to-reverse-binary-string/description/

class MinimumNumberOfFlipsToReverseBinaryString {
    public int minimumFlips(int n) {
        boolean isTest = false;
        char[] nBits = Integer.toBinaryString(n).toCharArray();
        char[] nBitsReverse = nBits.clone();
        int left = 0;
        int result = 0;
        int right = nBitsReverse.length - 1;

        while (left < right) {
            char temp = nBitsReverse[left];
            nBitsReverse[left++] = nBitsReverse[right];
            nBitsReverse[right--] = temp;
        }
        for (int i = 0; i < nBits.length; i++) {
            if (nBits[i] != nBitsReverse[i]) {
                result++;
            }
        }
        if (isTest) {
            System.out.println("nBits: " + Arrays.toString(nBits) + "\nnBitsReverse: " + Arrays.toString(nBitsReverse) + "\nresult: " + result);
        }

        return result;
    }
}