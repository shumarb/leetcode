// Question: https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/description/

class RedistributeCharactersToMakeAllStringsEqual {
    public boolean makeEqual(String[] words) {
        boolean isTest = false;
        int[] letterFrequency = new int[26];
        int wordCount = words.length;

        for (String word: words) {
            for (char letter: word.toCharArray()) {
                letterFrequency[letter - 'a']++;
            }
        }
        if (isTest) {
            System.out.println("words: " + Arrays.toString(words));
            System.out.println("letterFrequency: " + Arrays.toString(letterFrequency));
        }

        /**
         1.  Redistribution of characters to make array strings equal
             is possible only if frequency of each letter is divisible by total number of letters in words array.
         */
        for (int i = 0; i < letterFrequency.length; i++) {
            if (letterFrequency[i] % wordCount != 0) {
                return false;
            }
        }

        return true;
    }
}