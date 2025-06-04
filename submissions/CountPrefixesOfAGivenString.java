// Question: https://leetcode.com/problems/count-prefixes-of-a-given-string/description/

class CountPrefixesOfAGivenString {
    public int countPrefixes(String[] words, String s) {
        int countPrefixes = 0;
        for (String word: words) {
            if (s.startsWith(word)) {
                countPrefixes++;
            }
        }
        return countPrefixes;
    }
}