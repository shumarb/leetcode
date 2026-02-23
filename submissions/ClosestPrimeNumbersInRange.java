// Question: https://leetcode.com/problems/closest-prime-numbers-in-range/description/

class ClosestPrimeNumbersInRange {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = getPrimes(left, right);
        boolean isTest = false;
        int[] result = new int[] {-1, -1};

        if (right <= 2) {
            return result;
        }

        if (isTest) {
            System.out.println("primes: " + primes);
            System.out.println("-------------------------------------------");
        }
        if (primes.size() > 1) {
            int maximumDifference = Integer.MAX_VALUE;
            for (int i = 1; i < primes.size(); i++) {
                int first = primes.get(i - 1);
                int second = primes.get(i);
                int currentDifference = second - first;

                if (isTest) {
                    System.out.println(" * [" + first + ", " + second + "] -> difference: " + currentDifference);
                }
                if (currentDifference < maximumDifference) {
                    result[0] = first;
                    result[1] = second;
                    maximumDifference = currentDifference;
                }
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------");
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