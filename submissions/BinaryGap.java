// Question: https://leetcode.com/problems/binary-gap/description/

class BinaryGap {
    public int binaryGap(int n) {
        boolean isTest = false;
        char[] bits = Integer.toBinaryString(n).toCharArray();
        int lastIndex = 0;
        int result = 0;

        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1') {
                result = Math.max(result, i - lastIndex);
                lastIndex = i;
            }
        }
        if (isTest) {
            System.out.println("bits: " + Arrays.toString(bits) + "\nresult: " + result);
        }

        return result;
    }
}