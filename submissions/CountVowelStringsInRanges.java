// Question: https://leetcode.com/problems/count-vowel-strings-in-ranges/description/

class CountVowelStringsInRanges {
    public int[] vowelStrings(String[] words, int[][] queries) {
        boolean isTest = false;
        int countVowelStrings = 0;
        int m = words.length;
        int n = queries.length;
        int[] prefix = new int[m];
        int[] result = new int[n];

        for (int i = 0; i < m; i++) {
            if (isVowelString(words[i])) {
                countVowelStrings++;
            }
            prefix[i] = countVowelStrings;
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = left == 0 ? prefix[right] : prefix[right] - prefix[left - 1];
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix) + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }

    private boolean isVowelString(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
