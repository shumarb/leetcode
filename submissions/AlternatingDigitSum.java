// Question: https://leetcode.com/problems/alternating-digit-sum/description/

class AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        int count = 0;
        int nCopy = n;
        int sum = 0;

        while (nCopy > 0) {
            count++;
            nCopy /= 10;
        }
        for (int i = count; i >= 0; i--) {
            int digit = n % 10;
            if (i % 2 == 1) {
                sum += digit;
            } else {
                sum -= digit;
            }
            n /= 10;
        }

        return sum;
    }
}