// Question: https://leetcode.com/problems/check-good-integer/description/

class CheckGoodInteger {
    public boolean checkGoodInteger(int n) {
        boolean isTest = false;
        long digitSum = 0;
        long squareSum = 0;

        while (n > 0) {
            int digit = n % 10;
            digitSum += digit;
            squareSum += (digit * digit);
            n /= 10;
        }
        if (isTest) {
            System.out.println("digitSum: " + digitSum + "\nsquareSum: " + squareSum);
        }

        return squareSum - digitSum >= 50;
    }
}
