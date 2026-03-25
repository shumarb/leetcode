// Question: https://leetcode.com/problems/count-vowel-strings-in-ranges/description/

class CountVowelStringsInRanges {
    public int[] vowelStrings(String[] words, int[][] queries) {
        boolean isTest = false;
        int m = words.length;
        int n = queries.length;
        int[] prefix = new int[m];
        int[] result = new int[n];

        prefix[0] = isValid(words[0]) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            prefix[i] = isValid(words[i]) ? 1 + prefix[i - 1] : prefix[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == right) {
                result[i] = isValid(words[left]) ? 1 : 0;

            } else {
                result[i] = left == 0 ? prefix[right] : prefix[right] - prefix[left - 1];
            }
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix) + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }

    private boolean isValid(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
