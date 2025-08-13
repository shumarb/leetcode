// Question: https://leetcode.com/problems/second-largest-digit-in-a-string/description/

class SecondLargestDigitInAString {
    public int secondHighest(String s) {
        int count = 0;

        for (char digit = '9'; digit >= '0'; digit--) {
            if (s.indexOf(digit) >= 0) {
                count++;
                if (count == 2) {
                    return digit - '0';
                }
            }
        }

        return -1;
    }
}