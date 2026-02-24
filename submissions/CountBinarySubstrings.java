// Question: https://leetcode.com/problems/count-binary-substrings/description/

class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] bits = s.toCharArray();
        int currentConsecutive = 1;
        int previousConsecutive = 0;
        int result = 0;

        for (int i = 1; i < bits.length; i++) {
            if (bits[i] == bits[i - 1]) {
                currentConsecutive++;
            } else {
                result += Math.min(currentConsecutive, previousConsecutive);
                previousConsecutive = currentConsecutive;
                currentConsecutive = 1;
            }
        }
        result += Math.min(currentConsecutive, previousConsecutive);

        return result;
    }
}