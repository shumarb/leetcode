// Question: https://leetcode.com/problems/perfect-number/description/

class PerfectSquares {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }

        int sumOfDivisors = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                // i is a divisor of n ==> (n / i) is also a divisor of n
                // eg: 28 % 2 == 0 ==> (28 / 2) = 14 is also a divisor of 28
                // so by checking for a divisor, I can confirm 2 divisors: i & n / i
                sumOfDivisors += i;
                sumOfDivisors += (num / i);
            }
        }

        return sumOfDivisors == num;
    }
}