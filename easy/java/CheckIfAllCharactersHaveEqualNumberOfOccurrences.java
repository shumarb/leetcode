// Question: https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/description/

class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public boolean areOccurrencesEqual(String s) {
        boolean t = false;
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        if (t) {
            System.out.println("s: " + s + "\nfreq: " + Arrays.toString(freq));
        }

        int count = freq[s.charAt(0) - 'a'];
        if (t) {
            System.out.println("initial count: " + count);
        }
        for (int x: freq) {
            if (x > 0 && x != count) {
                return false;
            }
        }
        return true;
    }
}
