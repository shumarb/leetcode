// Question: https://leetcode.com/problems/number-of-substrings-with-only-1s/description/

class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        long count = 0;
        long result = 0;

        for (char c: s.toCharArray()) {
            if (c == '1') {
                result += ++count;
            } else {
                count = 0;
            }
        }

        return (int) (result % 1000000007);
    }
}
