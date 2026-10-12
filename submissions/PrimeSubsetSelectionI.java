// Question: https://leetcode.com/problems/prime-subset-selection-i/description/

class PrimeSubsetSelectionI {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> result = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
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

        for (int i = 0; i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }

            if (sum + i > s) {
                break;
            }

            result.add(i);
            sum += i;
        }

        return result;
    }
}
