// Question: https://leetcode.com/problems/distinct-prime-factors-of-product-of-array/description/

class DistinctPrimeFactorsOfProductOfArray {
    public int distinctPrimeFactors(int[] nums) {
        List<Integer> primes = getPrimes(nums);
        boolean isTest = false;
        int[] count = new int[primes.get(primes.size() - 1) + 1];
        int countDistinctPrimeFactors = 0;

        for (int element: nums) {
            int current = element;
            for (int prime: primes) {
                while (current > 1 && current % prime == 0) {
                    if (count[prime] == 0) {
                        countDistinctPrimeFactors++;
                    }
                    current /= prime;
                    count[prime]++;
                }
            }
        }
        if (isTest) {
            System.out.println("primes: " + primes + "\ncount: " + Arrays.toString(count) + "\ncountDistinctPrimeFactors: " + countDistinctPrimeFactors);
        }

        return countDistinctPrimeFactors;
    }

    private List<Integer> getPrimes(int[] nums) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime;
        int largest = 0;

        for (int element: nums) {
            largest = Math.max(element, largest);
        }
        isPrime = new boolean[largest + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= largest; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= largest; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= largest; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}