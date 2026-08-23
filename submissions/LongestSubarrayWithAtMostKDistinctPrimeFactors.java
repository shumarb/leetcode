// Question: https://leetcode.com/problems/longest-subarray-with-at-most-k-distinct-prime-factors/description/

class LongestSubarrayWithAtMostKDistinctPrimeFactors {
    public int longestSubarray(int[] nums, int k) {
        boolean[] isPrime;
        boolean isTest = false;
        int countDistinctPrimeFactors = 0;
        int largest = 0;
        int left = 0;
        int n = nums.length;
        int result = 0;
        int[][] primeFactors;
        int[] window;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        isPrime = new boolean[largest + 1];
        primeFactors = new int[largest + 1][];
        window = new int[largest + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= largest / i; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= largest; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums) + "\nisPrime: " + Arrays.toString(isPrime));
            System.out.println("---------------------------------------------------------------------------------------");
        }

        for (int i = 0; i < n; i++) {
            int element = nums[i];

            if (primeFactors[element] == null) {
                primeFactors[element] = getPrimeFactors(element, isPrime);
            }
            if (isTest) {
                System.out.println(" * " + element + ": " + Arrays.toString(primeFactors[element]));
            }
        }
        if (isTest) {
            System.out.println("---------------------------------------------------------------------------------------");
        }

        for (int right = 0; right < n; right++) {
            int incoming = nums[right];

            for (int e: primeFactors[incoming]) {
                if (++window[e] == 1) {
                    countDistinctPrimeFactors++;
                }
            }

            while (countDistinctPrimeFactors > k) {
                int remove = nums[left++];

                for (int e: primeFactors[remove]) {
                    if (--window[e] == 0) {
                        countDistinctPrimeFactors--;
                    }
                }
            }

            int length = right - left + 1;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | length: " + length + " | window: " + Arrays.toString(window));
            }

            result = Math.max(result, right - left + 1);
        }
        if (isTest) {
            System.out.println("---------------------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private int[] getPrimeFactors(int e, boolean[] isPrime) {
        List<Integer> primes = new ArrayList<>();
        int[] result;
        int n;

        for (int i = 2; i <= e / i; i++) {
            if (isPrime[i] && e % i == 0) {
                primes.add(i);
            }

            // 1. Exponentionally reduce e by dividing itself with i to avoid checking if its multiples are prime.
            while (e % i == 0) {
                e /= i;
            }
        }
        if (isPrime[e]) {
            primes.add(e);
        }

        n = primes.size();
        result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = primes.get(i);
        }

        return result;
    }
}
