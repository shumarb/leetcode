// Question: https://leetcode.com/problems/merge-strings-alternately/description/

class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        char[] word1Letters = word1.toCharArray();
        char[] word2Letters = word2.toCharArray();
        int i = 0;
        int j = 0;
        int m = word1Letters.length;
        int n = word2Letters.length;

        while (i < m && j < n) {
            result.append(word1Letters[i++]);
            result.append(word2Letters[j++]);
        }
        result.append(word1.substring(i));
        result.append(word2.substring(j));

        return result.toString();
    }
}
