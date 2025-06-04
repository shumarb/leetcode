// Question: https://leetcode.com/problems/valid-anagram/description/

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // 1. Invalid anagram for strings of different lengths.
        if (s.length() != t.length()) {
            return false;
        }

        /** 2.  Count letters in each string, and check if both are equal one another.
         If both are equal to another, result is valid anagrams.
         Otherwise, result is invalid anagrams.
         */
        int[] sLetterFrequency = countLettersInString(s);
        int[] tLetterFrequency = countLettersInString(t);
        return Arrays.equals(sLetterFrequency, tLetterFrequency);
    }

    private int[] countLettersInString(String str) {
        int[] letterFrequency = new int[26];
        for (char letter: str.toCharArray()) {
            letterFrequency[letter - 'a']++;
        }
        return letterFrequency;
    }
}