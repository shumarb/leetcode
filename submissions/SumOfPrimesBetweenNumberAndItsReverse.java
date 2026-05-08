// Question: https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/description/

class SumOfPrimesBetweenNumberAndItsReverse {
    public int sumOfPrimesInRange(int n) {
        boolean[] isPrime;
        boolean isTest = false;
        int maximum = 0;
        int minimum = 0;
        int nCopy = n;
        int r = 0;
        int result = 0;

        while (nCopy > 0) {
            r *= 10;
            r += nCopy % 10;
            nCopy /= 10;
        }
        maximum = Math.max(n, r);
        minimum = Math.min(n, r);
        if (isTest) {
            System.out.println("n: " + n + "\nr: " + r);
            System.out.println("maximum: " + maximum + "\nminimum: " + minimum);
        }

        isPrime = new boolean[maximum + 1];
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= maximum; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= maximum; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maximum; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = minimum; i <= maximum; i++) {
            if (isPrime[i]) {
                result += i;
            }
        }
        if (isTest) {
            System.out.println("isPrime: " + Arrays.toString(isPrime) + "\nresult: " + result);
        }

        return result;
    }
}
