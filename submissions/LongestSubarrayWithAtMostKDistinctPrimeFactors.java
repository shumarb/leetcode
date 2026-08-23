// Question: https://leetcode.com/problems/longest-subarray-with-at-most-k-distinct-prime-factors/description/

class LongestSubarrayWithAtMostKDistinctPrimeFactors {
    public int longestSubarray(int[] nums, int k) {
        boolean[] isPrime;
        boolean isTest = false;
        int largest = 0;
        int left = 0;
        int n = nums.length;
        int result = 0;
        List<Integer>[] primeFactors = new ArrayList[n];
        Map<Integer, Integer> union = new HashMap<>();

        for (int i = 0; i < n; i++) {
            primeFactors[i] = new ArrayList<>();
        }
        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        isPrime = new boolean[largest + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= largest / i; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= largest; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            primeFactors[i] = getPrimeFactors(nums[i], isPrime);
        }

        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums));
            System.out.println("---------------------------------------------\nprimeFactors: ");
            for (int i = 0; i < n; i++) {
                System.out.println(" * " + nums[i] + ": " + primeFactors[i]);
            }
            System.out.println("---------------------------------------------");
        }

        for (int right = 0; right < n; right++) {
            List<Integer> primes = primeFactors[right];

            for (int e: primes) {
                union.merge(e, 1, Integer::sum);
            }

            while (union.size() > k) {
                List<Integer> primesToRemove = primeFactors[left++];
                for (int e: primesToRemove) {
                    union.put(e, union.get(e) - 1);
                    if (union.get(e) == 0) {
                        union.remove(e);
                    }
                }
            }

            int length = right - left + 1;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | length: " + length + " | union: " + union);
            }

            result = Math.max(length, result);
        }
        if (isTest) {
            System.out.println("---------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private List<Integer> getPrimeFactors(int key, boolean[] isPrime) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= key / i; i++) {
            if (isPrime[i] && key % i == 0) {
                result.add(i);

                while (key % i == 0) {
                    key /= i;
                }
            }
        }

        if (key > 1) {
            result.add(key);
        }

        return result;
    }
}
