// Question: https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/description/

class FindTheLongestBalancedSubstringOfABinaryString {
    public int findTheLongestBalancedSubstring(String s) {
        int i = 0;
        int len = s.length();
        int longest = 0;

        while (i < len) {
            if (s.charAt(i) == '1') {
                i++;
                continue;
            }

            int countConsecutiveZeroes = 0;
            while (i < len && s.charAt(i) == '0') {
                countConsecutiveZeroes++;
                i++;
            }

            int countConsecutiveOnes = 0;
            int j = i;
            while (j < len && s.charAt(j) == '1') {
                j++;
                countConsecutiveOnes++;
            }
            longest = Math.max(longest, 2 * Math.min(countConsecutiveOnes, countConsecutiveZeroes));

            i = j;
        }

        return longest;
    }
}