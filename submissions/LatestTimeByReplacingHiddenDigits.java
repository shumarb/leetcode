// Question: https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/description/

class LatestTimeByReplacingHiddenDigits {
    public String findLatestTime(String s) {
        char[] result = s.toCharArray();

        if (result[0] == '?' && result[1] == '?') {
            result[0] = '1';
            result[1] = '1';
        } else if (result[0] == '?' && result[1] != '?') {
            result[0] = result[1] <= '1' ? '1' : '0';
        } else if (result[1] == '?' && result[0] != '?') {
            result[1] = result[0] == '0' ? '9' : '1';
        }

        if (result[3] == '?') {
            result[3] = '5';
        }

        if (result[4] == '?') {
            result[4] = '9';
        }

        return new String (result);
    }
}
