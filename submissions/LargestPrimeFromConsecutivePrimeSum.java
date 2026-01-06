// Question: leetcode.com/problems/largest-prime-from-consecutive-prime-sum/description/

class LargestPrimeFromConsecutivePrimeSum {
    public int largestPrime(int n) {
        if (n < 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n + 1];
        int result = 0;
        int sum = 0;

        Arrays.fill(isPrime, 2, isPrime.length, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                sum += i;
                if (sum > n) {
                    break;
                }
                if (isPrime[sum]) {
                    result = sum;
                }
            }
        }

        return result;
    }
}