// Question: https://leetcode.com/problems/count-binary-substrings/description/

class CountBinaryStrings {
    public int countBinarySubstrings(String s) {
        int currentConsecutive = 1;
        int previousConsecutive = 0;
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
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