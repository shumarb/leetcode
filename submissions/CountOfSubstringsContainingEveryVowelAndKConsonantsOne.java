// Question: https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/

class CountOfSubstringsContainingEveryVowelAndKConsonantsOne {
    public int countOfSubstrings(String word, int k) {
        boolean isTest = false;
        int n = word.length();
        int result = 0;
        int windowSize = 5 + k;

        for (int i = 0; i <= n - windowSize; i++) {
            boolean[] isSeen = new boolean[26];
            int countConsonants = 0;
            int countUnique = 0;

            for (int j = i; j < n; j++) {
                char letter = word.charAt(j);
                if (isVowel(letter)) {
                    if (!isSeen[letter - 'a']) {
                        isSeen[letter - 'a'] = true;
                        countUnique++;
                    }
                } else {
                    countConsonants++;
                }

                if (countUnique == 5 && countConsonants == k) {
                    if (isTest) {
                        System.out.println(" * counted: " + word.substring(i, j + 1));
                    }
                    result++;

                } else if (countConsonants > k) {
                    break;
                }
            }
        }

        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}