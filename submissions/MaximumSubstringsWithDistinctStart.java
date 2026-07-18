// Question: https://leetcode.com/problems/maximum-substrings-with-distinct-start/description/

class MaximumSubstringsWithDistinctStart {
    public int maxDistinct(String s) {
        int[] count = new int[26];
        int result = 0;

        for (char c: s.toCharArray()) {
            if (++count[c - 'a'] == 1) {
                result++;
            }

            if (result == 26) {
                break;
            }
        }

        return result;
    }
}
