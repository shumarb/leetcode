// Question: https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/

class CountOfSubstringsContainingEveryVowelAndKConsonantsI {
    private char[] letters;

    public int countOfSubstrings(String word, int k) {
        letters = word.toCharArray();
        return countAtLeast(k) - countAtLeast(k + 1);
    }

    private int countAtLeast(int limit) {
        int[] count = new int[26];
        int countConsonants = 0;
        int countUniqueVowels = 0;
        int left = 0;
        int n = letters.length;
        int result = 0;

        for (int right = 0; right < n; right++) {
            char incoming = letters[right];

            if (isVowel(incoming)) {
                if (++count[incoming - 'a'] == 1) {
                    countUniqueVowels++;
                }
            } else {
                countConsonants++;
            }

            while (countUniqueVowels == 5 && countConsonants >= limit) {
                result += (n - right);

                char remove = letters[left++];

                if (isVowel(remove)) {
                    if (--count[remove - 'a'] == 0) {
                        countUniqueVowels--;
                    }
                } else {
                    countConsonants--;
                }
            }
        }

        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
