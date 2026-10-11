// Question: https://leetcode.com/contest/weekly-contest-523/problems/prime-subset-selection-i/description/

class PrimeSubsetSelectionI {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> result = new ArrayList<>();
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        boolean isTest = false;
        int sum = 0;

        if (s == 1) {
            return result;
        }

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        if (isTest) {
            System.out.println("n: " + n + "\ns: " + s + "\nprimes: " + primes);
        }

        for (int i = 0; i < primes.size() && sum <= s; i++) {
            int e = primes.get(i);

            if (sum + e > s) {
                break;
            }

            result.add(e);
            sum += e;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}
