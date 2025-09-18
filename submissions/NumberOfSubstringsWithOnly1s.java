// Question: https://leetcode.com/problems/number-of-substrings-with-only-1s/description/

class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        int modulo = 1000000007;
        long current = 0;
        long total = 0;

        for (char c: s.toCharArray()) {
            if (c == '1') {
                current++;
            } else {
                total += (current * (current + 1)) / 2;
                total %= modulo;
                current = 0;
            }
        }
        total += (current * (current + 1)) / 2;
        total %= modulo;

        return (int) total;
    }
}
