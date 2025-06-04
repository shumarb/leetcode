// Question: https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/

class CountPrefixAndSuffixPairsOn {
    public int countPrefixSuffixPairs(String[] words) {
        int countPrefixSuffixPairs = 0;
        int len = words.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String first = words[i];
                String second = words[j];
                if (second.startsWith(first) && second.endsWith(first)) {
                    countPrefixSuffixPairs++;
                }
            }
        }
        return countPrefixSuffixPairs;
    }

}