// Question: https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/description/

class CountTheNumberOfVowelStringsInRange {
    public int vowelStrings(String[] words, int left, int right) {
        int countVowelStrings = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                countVowelStrings++;
            }
        }
        return countVowelStrings;
    }

    private boolean isVowel(char letter) {
        return letter == 'a' || letter == 'o' || letter == 'i' || letter == 'e' || letter == 'u';
    }
}