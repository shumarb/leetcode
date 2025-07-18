// Question: https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/

class CountOfSubstringsContainingEveryVowelAndKConsonantsOne {
    public int countOfSubstrings(String word, int k) {
        boolean isTest = false;
        int countOfSubstrings = 0;
        int len = word.length();

        for (int i = 0; i < len; i++) {
            StringBuilder current = new StringBuilder();
            for (int j = i; j < len; j++) {
                current.append(word.charAt(j));
                if (current.length() >= 5 && isValid(current.toString(), k)) {
                    if (isTest) {
                        System.out.println(" * valid: " + current.toString());
                    }
                    countOfSubstrings++;
                }
            }
        }

        return countOfSubstrings;
    }

    private boolean isValid(String word, int k) {
        int[] frequency = new int[26];
        int countConsonants = 0;
        for (char c: word.toCharArray()) {
            frequency[c - 'a']++;
            if (!isVowel(c)) {
                countConsonants++;
            }
        }

        if (countConsonants != k) {
            return false;
        }

        if (frequency['a' - 'a'] == 0 || frequency['e' - 'a'] == 0 ||
                frequency['i' - 'a'] == 0 || frequency['o' - 'a'] == 0 || frequency['u' - 'a'] == 0) {
            return false;

        }

        return true;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}