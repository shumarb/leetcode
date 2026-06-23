// Question: https://leetcode.com/problems/longest-repeating-character-replacement/description/

class LongestRepeatingCharacterReplacement {
    private boolean isTest;
    private char[] letters;
    private int k;

    public int characterReplacement(String s, int k) {
        boolean[] isPresent = new boolean[26];
        int result = 0;
        isTest = false;
        letters = s.toCharArray();
        this.k = k;

        if (letters.length == 1) {
            return 1;
        }

        if (isTest) {
            System.out.println("k: " + k + "\nletters: " + Arrays.toString(letters));
        }
        for (char c: letters) {
            if (!isPresent[c - 'A']) {
                int longestReplacementLength = getLongestReplacementLength(c);
                result = Math.max(longestReplacementLength, result);
                isPresent[c - 'A'] = true;
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private int getLongestReplacementLength(char letter) {
        int left = 0;
        int limit = k;
        int result = 0;

        if (isTest) {
            System.out.println("--------------------------------------------------\nletter: " + letter);
        }
        for (int right = 0; right < letters.length; right++) {
            if (letters[right] != letter) {
                limit--;
            }

            while (limit < 0) {
                if (letters[left++] != letter) {
                    limit++;
                }
            }

            int length = right - left + 1;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | limit: " + limit
                        + " | length: " + length + " | subarray: " + Arrays.toString(Arrays.copyOfRange(letters, left, right + 1))
                );
            }

            result = Math.max(length, result);
        }

        return result;
    }
}
