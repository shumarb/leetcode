// Question: https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/description/

class CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int j = 0;
        int n = queries.length;
        int[] result = new int[n];

        for (String query: queries) {
            int count = 0;
            for (String word: words) {
                if (isValid(query, word)) {
                    count++;
                }
            }
            result[j++] = count;
        }

        return result;
    }

    private boolean isValid(String query, String word) {
        int[] queryCount = new int[26];
        int[] wordCount = new int[26];
        int querySmallestCount = 0;
        int wordSmallestCount = 0;

        for (char c: query.toCharArray()) {
            queryCount[c - 'a']++;
        }
        for (char c: word.toCharArray()) {
            wordCount[c - 'a']++;
        }

        for (int i = 0; i < queryCount.length; i++) {
            if (queryCount[i] > 0) {
                querySmallestCount = queryCount[i];
                break;
            }
        }

        for (int i = 0; i < wordCount.length; i++) {
            if (wordCount[i] > 0) {
                wordSmallestCount = wordCount[i];
                break;
            }
        }

        return querySmallestCount < wordSmallestCount;
    }
}