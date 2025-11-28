// Question: https://leetcode.com/problems/minimum-number-of-flips-to-reverse-binary-string/description/

class MinimumNumberOfFlipsToReverseBinaryString {
    public int minimumFlips(int n) {
        boolean isTest = false;
        char[] nBits = Integer.toBinaryString(n).toCharArray();
        int left = 0;
        int result = 0;
        int right = nBits.length - 1;

        while (left < right) {
            if (nBits[left] != nBits[right]) {
                result += 2;
            }
            left++;
            right--;
        }
        if (isTest) {
            System.out.println("nBits: " + Arrays.toString(nBits) + "\nresult: " + result);
        }

        return result;
    }
}