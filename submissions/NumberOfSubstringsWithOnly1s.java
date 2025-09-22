// Question: https://leetcode.com/problems/number-of-substrings-with-only-1s/description/

class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        int modulo = 1000000007;
        long current = 0;
        long total = 0;

        for (char c: s.toCharArray()) {
            if (c == '1') {
                current++;
                total = (total + current) % modulo;
            } else {
                current = 0;
            }
        }

        return (int) total;
    }
}