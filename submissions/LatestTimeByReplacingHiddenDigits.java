// Question: https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/description/

class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        char[] digits = time.toCharArray();

        if (digits[0] == '?') {
            if (digits[1] == '?' || digits[1] <= '3') {
                digits[0] = '2';
            }
            else {
                digits[0] = '1';
            }
        }

        if (digits[1] == '?') {
            digits[1] = digits[0] == '0' || digits[0] == '1' ? '9' : '3';
        }

        if (digits[3] == '?') {
            digits[3] = '5';
        }

        if (digits[4] == '?') {
            digits[4] = '9';
        }

        return new String(digits);
    }
}
