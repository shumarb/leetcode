// Question: https://leetcode.com/problems/count-integers-with-even-digit-sum/description/

class CountIntegersWithEvenDigitSum {
    public int countEven(int num) {
        int c = 0;
        for (int i = 2; i <= num; i++) {
            if (isEvenSum(i)) {
                c++;
            }
        }
        return c;
    }

    private boolean isEvenSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return (sum % 2) == 0;
    }
}