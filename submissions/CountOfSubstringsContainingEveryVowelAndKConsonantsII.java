// Question: https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/

class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    private char[] letters;

    public long countOfSubstrings(String word, int k) {
        letters = word.toCharArray();
        return countAtLeast(k) - countAtLeast(k + 1);
    }

    private long countAtLeast(int limit) {
        int[] count = new int[26];
        int countConsonants = 0;
        int countUniqueVowels = 0;
        int left = 0;
        int n = letters.length;
        long result = 0l;

        for (int right = 0; right < n; right++) {
            char incoming = letters[right];

            if (incoming == 'a' || incoming == 'e' || incoming == 'i' || incoming == 'o' || incoming == 'u') {
                if (++count[incoming - 'a'] == 1) {
                    countUniqueVowels++;
                }
            } else {
                countConsonants++;
            }

            while (countUniqueVowels == 5 && countConsonants >= limit) {
                result += (n - right);

                char remove = letters[left++];

                if (remove == 'a' || remove == 'e' || remove == 'i' || remove == 'o' || remove == 'u') {
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
}
