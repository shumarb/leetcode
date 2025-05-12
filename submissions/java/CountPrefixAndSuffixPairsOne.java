// Question: https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/

class CountPrefixAndSuffixPairsOne {
    public int countPrefixSuffixPairs(String[] words) {
        int countPrefixSuffixPairs = 0;
        int len = words.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String first = words[i];
                String second = words[j];
                if (first.length() <= second.length() && isPrefixAndSuffix(first, second)) {
                    countPrefixSuffixPairs++;
                }
            }
        }
        return countPrefixSuffixPairs;
    }

    private boolean isPrefixAndSuffix(String first, String second) {
        if (first.length() == second.length()) {
            return first.equals(second);
        }
        int firstLen = first.length();
        int secondLen = second.length();
        return second.substring(0, firstLen).equals(first) && second.substring(secondLen - firstLen, secondLen).equals(first);
    }
}