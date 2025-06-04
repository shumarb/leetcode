// Question: https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/

class /FindMaximumNumberOfStringPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        int count = 0;

        for (String word: words) {
            StringBuilder wordComplement = new StringBuilder(word);
            if (set.contains(wordComplement.reverse().toString())) {
                count++;
            } else {
                set.add(word);
            }
        }

        return count;
    }
}