// Question: https://leetcode.com/problems/closest-prime-numbers-in-range/description/

class ClosestPrimeNumbersInRange {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = getPrimes(left, right);
        boolean isTest = false;
        int[] result = new int[] {-1, -1};

        if (isTest) {
            System.out.println("primes: " + primes);
        }
        if (primes.size() > 1) {
            result[0] = primes.get(0);
            result[1] = primes.get(1);
            for (int i = 1; i < primes.size() - 1; i++) {
                int first = primes.get(i);
                int second = primes.get(i + 1);
                if (isTest) {
                    System.out.println(" * pair: [" + first + ", " + second + "]");
                }
                if ((second - first) < (result[1] - result[0]))  {
                    result[0] = first;
                    result[1] = second;
                }
            }
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private List<Integer> getPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[right + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}