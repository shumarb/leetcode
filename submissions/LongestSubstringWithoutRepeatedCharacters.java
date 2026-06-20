// Question: https://leetcode.com/problems/ongest-substring-without-repeating-characters/description/

class LongestSubstringWithoutRepeatedCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] letters = s.toCharArray();
        int[] count = new int[128];
        int left = 0;
        int result = 0;

        for (int right = 0; right < letters.length; right++) {
            char incoming = letters[right];

            count[incoming]++;
            while (count[incoming] > 1) {
                count[letters[left++]]--;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
