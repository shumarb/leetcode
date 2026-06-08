// Question: https://leetcode.com/problems/merge-strings-alternately/description/

class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int n = Math.min(word1.length(), word2.length());

        for (int i = 0; i < n; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        result.append(word1.substring(n));
        result.append(word2.substring(n));

        return result.toString();
    }
}
