// Question: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int countVowels = 0;
        int maxVowels = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                countVowels++;
            }
        }
        maxVowels = Math.max(countVowels, maxVowels);
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) {
                countVowels--;
            }
            if (isVowel(s.charAt(i))) {
                countVowels++;
            }
            maxVowels = Math.max(countVowels, maxVowels);
        }

        return maxVowels;
    }

    private boolean isVowel(char letter) {
        String vowels = "aeiou";
        return vowels.indexOf(letter) != -1;
    }
}