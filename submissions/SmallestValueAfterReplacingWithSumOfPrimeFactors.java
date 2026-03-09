// Question: https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/description/

class SmallestValueAfterReplacingWithSumOfPrimeFactors {
    public int smallestValue(int n) {
        boolean[] isPrime = new boolean[n + 1];
        boolean isTest = false;
        int result = n;

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        if (isTest) {
            System.out.println("isPrime: " + Arrays.toString(isPrime));
            System.out.println("-------------------------------------------------");
        }

        while (!isPrime[n]) {
            if (isTest) {
                System.out.println(" * before, n: " + n);
            }

            int sumOfPrimes = getSumOfPrimes(isPrime, n);
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

    private int getSumOfPrimes(boolean[] isPrime, int n) {
        int result = 0;

        for (int i = 2; i < isPrime.length; i++) {
            while (n > 1 && n % i == 0) {
                result += i;
                n /= i;
            }
        }

        return result;
    }
}