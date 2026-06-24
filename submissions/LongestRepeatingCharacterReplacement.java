// Question: https://leetcode.com/problems/longest-repeating-character-replacement/description/

class LongestRepeatingCharacterReplacement {
    private char[] letters;
    private int k;
    private int result;

    public int characterReplacement(String s, int k) {
        boolean[] isPresent = new boolean[26];
        int n = s.length();
        letters = s.toCharArray();
        result = 0;
        this.k = k;

        if (n == 1) {
            return 1;
        }

        for (char c: letters) {
            if (!isPresent[c - 'A']) {
                getLongestReplacementLength(c);

                // 1. Stop all checks if longest replacement length is equal to string's length.
                if (result == n) {
                    return n;
                }

                isPresent[c - 'A'] = true;
            }
        }

        return result;
    }

    private void getLongestReplacementLength(char letter) {
        int left = 0;
        int limit = k;

        for (int right = 0; right < letters.length; right++) {
            if (letters[right] != letter) {
                limit--;
            }

            while (limit < 0) {
                if (letters[left++] != letter) {
                    limit++;
                }
            }

            result = Math.max(result, right - left + 1);
        }
    }
}
