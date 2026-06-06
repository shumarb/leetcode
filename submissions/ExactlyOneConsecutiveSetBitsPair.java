// Question: https://leetcode.com/problems/exactly-one-consecutive-set-bits-pair/description/

class ExactlyOneConsecutiveSetBitsPair {
    public boolean consecutiveSetBits(int n) {
        boolean isTest = false;
        char[] bits = Integer.toBinaryString(n).toCharArray();
        int countConsecutiveSetBits = 0;

        if (isTest) {
            System.out.println("n: " + n + "\nbits: " + Arrays.toString(bits));
        }
        for (int i = 1; i < bits.length; i++) {
            if (bits[i] == '1' && bits[i - 1] == '1') {
                if (++countConsecutiveSetBits > 1) {
                    return false;
                }
            }
        }

        return countConsecutiveSetBits == 1;
    }
}
