// Question: https://leetcode.com/problems/count-number-of-homogenous-substrings/description/

class CountNumberOfHomogenousSubstrings {
    public int countHomogenous(String s) {
        long count = 1;
        long modulo = 1000000007;
        long result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;

            } else {
                result += count * (count + 1) / 2;
                count = 1;
            }
        }
        result += count * (count + 1) / 2;
        result %= modulo;

        return (int) result;
    }
}