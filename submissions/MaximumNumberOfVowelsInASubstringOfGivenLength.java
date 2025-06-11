// Question: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int countVowels = 0;
        int maxVowels = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                countVowels++;
            }
        }
        maxVowels = countVowels;
        for (int i = k; i < s.length(); i++) {
            if ("aeiou".indexOf(s.charAt(i - k)) != -1) {
                countVowels--;
            }
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                countVowels++;
            }
            maxVowels = Math.max(countVowels, maxVowels);
        }

        return maxVowels;
    }
}