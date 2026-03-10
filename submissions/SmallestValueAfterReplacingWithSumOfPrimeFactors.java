// Question: https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/description/

class SmallestValueAfterReplacingWithSumOfPrimeFactors {
    public int smallestValue(int n) {
        boolean isTest = false;
        int result = n;

        while (n > 1 && !isPrime(n)) {
            if (isTest) {
                System.out.println(" * before, n: " + n);
            }

            int sumOfPrimes = getSumOfPrimes(n);
            if (n == sumOfPrimes) {
                break;
            }
            n = sumOfPrimes;
            result = sumOfPrimes;

            if (isTest) {
                System.out.println(" * after, n: " + n);
                System.out.println("-------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int getSumOfPrimes(int n) {
        int current = n;
        int result = 0;

        for (int i = 2; i * i <= n; i++) {
            while (current % i == 0) {
                result += i;
                current /= i;
            }
        }
        if (current > 1) {
            result += current;
        }

        return result;
    }
}