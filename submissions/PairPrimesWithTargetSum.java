// Question: https://leetcode.com/problems/prime-pairs-with-target-sum/description/

class PairPrimesWithTargetSum {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> counted = new HashSet<>();
        Set<Integer> primes = new HashSet<>();
        boolean[] isPrime = new boolean[n + 1];
        boolean isTest = false;

        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        for (int e: primes) {
            int complement = n - e;
            if (counted.contains(e) && counted.contains(complement)) {
                continue;
            }
            if (primes.contains(e) && primes.contains(complement)) {
                List<Integer> pair = new ArrayList<>();
                counted.add(e);
                counted.add(complement);
                pair.add(e);
                pair.add(complement);
                if (pair.get(0) > pair.get(1)) {
                    int temp = pair.get(0);
                    pair.set(0, pair.get(1));
                    pair.set(1, temp);
                }
                result.add(pair);
            }
        }
        Collections.sort(result,
                (a, b) -> Integer.compare(a.get(0), b.get(0)) == 0
                        ? Integer.compare(a.get(1), b.get(1))
                        : Integer.compare(a.get(0), b.get(0))
        );
        if (isTest) {
            System.out.println("primes: " + primes);
            System.out.println("------------------------------\nresult: ");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }
}