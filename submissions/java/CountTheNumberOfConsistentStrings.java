// Question: https://leetcode.com/problems/count-the-number-of-consistent-strings/description/

class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedFreq = new boolean[26];
        boolean t = false;
        populate(allowed, allowedFreq);
        if (t) {
            System.out.println("allowed: " + allowed);
            System.out.println("words: " + Arrays.toString(words));
            System.out.println("allowedFreq: " + Arrays.toString(allowedFreq));
        }

        int count = 0;
        for (String word: words) {
            if (isConsistent(word, allowedFreq)) {
                count++;
            }
        }
        return count;
    }

    private boolean isConsistent(String word, boolean[] allowedFreq) {
        for (char c: word.toCharArray()) {
            if (!allowedFreq[c - 'a']) {
                return false;
            }
        }
        return true;
    }

    private void populate(String s, boolean[] freq) {
        for (char c: s.toCharArray()) {
            freq[c - 'a'] = true;
        }
    }
}