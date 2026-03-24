// Question: https://leetcode.com/problems/count-primes/description/

class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        boolean isTest = false;
        int result = 0;

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                result++;
            }
        }
        if (isTest) {
            System.out.print("prime numbers: ");
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("\n-----------------------------\nresult: " + result);
        }

        return result;
    }
}
