// Question: https://leetcode.com/problems/prime-arrangements/description/

class PrimeArrangements {
    public int numPrimeArrangements(int n) {
        boolean[] isPrime = new boolean[n + 1];
        boolean isTest = false;
        int countNonPrimes = 0;
        int countPrimes = 0;
        int mod = 1000000007;
        long result = 1;

        Arrays.fill(isPrime, 2, n + 1, true);
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                countPrimes++;
            }
        }
        countNonPrimes = n - countPrimes;

        for (int i = 2; i <= countPrimes; i++) {
            result = (result * i) % mod;
        }
        for (int i = 2; i <= countNonPrimes; i++) {
            result = (result * i) % mod;
        }
        if (isTest) {
            System.out.println("isPrime: " + Arrays.toString(isPrime));
            System.out.print("prime numbers: ");
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("\ncountPrimes: " + countPrimes + ", countNonPrimes: " + countNonPrimes + "\nresult: " + result);
        }

        return (int) result;
    }
}