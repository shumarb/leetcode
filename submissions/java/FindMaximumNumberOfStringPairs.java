// Question: https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/

class /FindMaximumNumberOfStringPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                StringBuilder first = new StringBuilder();
                for (char letter: words[i].toCharArray()) {
                    first.append(letter);
                }
                if (first.reverse().toString().equals(words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}