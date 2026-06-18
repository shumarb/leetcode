// Question: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/

class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        char[] letters = s.toCharArray();
        int n = letters.length;
        int result = 0;

        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] count = new int[26];
            int countAtLeastK = 0;
            int countUnique = 0;
            int left = 0;

            for (int right = 0; right < n; right++) {
                char incoming = letters[right];

                if (++count[incoming - 'a'] == 1) {
                    countUnique++;
                }
                if (count[incoming - 'a'] == k) {
                    countAtLeastK++;
                }

                while (countUnique > targetUnique) {
                    char remove = letters[left++];

                    if (count[remove - 'a'] == k) {
                        countAtLeastK--;
                    }
                    if (--count[remove - 'a'] == 0) {
                        countUnique--;
                    }
                }

                if (countUnique == targetUnique && countAtLeastK == targetUnique) {
                    result = Math.max(result, right - left + 1);
                }
            }
        }

        return result;
    }
}
