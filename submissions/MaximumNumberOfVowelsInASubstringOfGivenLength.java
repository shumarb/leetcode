// Question: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        char[] letters = s.toCharArray();
        int current = 0;
        int n = letters.length;
        int result;

        for (int i = 0; i < k; i++) {
            if (isVowel(letters[i])) {
                current++;
            }
        }

        result = current;

        for (int i = k; i < n; i++) {
            if (isVowel(letters[i - k])) {
                current--;
            }
            if (isVowel(letters[i])) {
                current++;
            }

            result = Math.max(current, result);
        }

        return result;
    }

    private boolean isVowel(char letter) {
        return letter == 'a'
                || letter == 'e'
                || letter == 'i'
                || letter == 'o'
                || letter == 'u';
    }
}
