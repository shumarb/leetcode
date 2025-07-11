// Question: https://leetcode.com/problems/count-vowel-substrings-of-a-string/description/

class CountVowelSubstringsOfAString {
    public int countVowelSubstrings(String word) {
        boolean isTest = false;
        int countVowelSubstrings = 0;
        int len = word.length();

        for (int i = 0; i < word.length(); i++) {
            if ("aeiou".indexOf(word.charAt(i)) != -1) {
                int j = i + 1;
                while (j < len && "aeiou".indexOf(word.charAt(j)) != -1) {
                    if (isValid(word.substring(i, j + 1))) {
                        if (isTest) {
                            System.out.println(" * valid: " + word.substring(i, j + 1));
                        }
                        countVowelSubstrings++;
                    }
                    j++;
                }
            }
        }

        return countVowelSubstrings;
    }

    private boolean isValid(String word) {
        int[] frequency = new int[26];

        for (char letter: word.toCharArray()) {
            frequency[letter - 'a']++;
        }
        for (char letter: word.toCharArray()) {
            if ("aeiou".indexOf(letter) == -1 && frequency[letter - 'a'] > 0) {
                return false;
            }
        }

        return frequency['a' - 'a'] > 0 && frequency['e' - 'a'] > 0
                && frequency['i' - 'a'] > 0 && frequency['o' - 'a'] > 0 && frequency['u' - 'a'] > 0;
    }
}