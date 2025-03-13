// Question: https://leetcode.com/problems/permutation-in-string/description/

class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        /**
         1.  Edge case: s2 is shorter than s1,
             hence s1's permutation is not a substring of s2.
         */
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] s1LetterFrequency = countLetters(s1);
        int windowSize = s1.length();
        StringBuilder window = new StringBuilder();

        for (int i = 0; i < windowSize; i++) {
            window.append(s2.charAt(i));
        }
        int[] windowLetterFrequency = countLetters(window.toString());
        if (isS1Permutation(s1LetterFrequency, windowLetterFrequency)) {
            return true;
        }

        for (int i = windowSize; i < s2.length(); i++) {
            windowLetterFrequency[s2.charAt(i - windowSize) - 'a']--;
            windowLetterFrequency[s2.charAt(i) - 'a']++;
            if (isS1Permutation(s1LetterFrequency, windowLetterFrequency)) {
                return true;
            }
        }

        return false;
    }

    private boolean isS1Permutation(int[] s1LetterFrequency, int[] windowLetterFrequency) {
        return Arrays.equals(s1LetterFrequency, windowLetterFrequency);
    }

    private int[] countLetters(String word) {
        int[] letterFrequency = new int[26];
        for (int i = 0; i < word.length(); i++) {
            letterFrequency[word.charAt(i) - 'a']++;
        }
        return letterFrequency;
    }
}