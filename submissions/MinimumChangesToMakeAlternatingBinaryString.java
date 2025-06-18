// Question: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/

class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        char[] bits = s.toCharArray();
        int change1 = 0;
        int change2 = 0;
        int first = '1';
        int second = '0';

        for (int i = 0; i < bits.length; i++) {
            char bit = bits[i];
            if (first != bit) {
                change1++;
            }
            if (second != bit) {
                change2++;
            }
            if (first == '1') {
                first = '0';
            } else {
                first = '1';
            }
            if (second == '1') {
                second = '0';
            } else {
                second = '1';
            }
        }

        return Math.min(change1, change2);
    }
}