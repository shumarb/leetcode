// Question: https://leetcode.com/problems/counting-words-with-a-given-prefix/description/

class CountingWordsWithAGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        for (String word: words) {
            if (word.startsWith(pref, 0)) {
                count++;
            }
        }

        return count;
    }
}