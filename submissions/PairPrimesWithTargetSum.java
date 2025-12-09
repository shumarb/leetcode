// Question: https://leetcode.com/problems/prime-pairs-with-target-sum/description/

class PairPrimesWithTargetSum {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isCounted = new boolean[n + 1];
        boolean[] isPrime = new boolean[n + 1];
        boolean isTest = false;

        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            int complement = n - i;
            if (isPrime[i] && isPrime[complement] && !isCounted[i] && !isCounted[complement]) {
                List<Integer> pair = new ArrayList<>();
                pair.add(Math.min(i, complement));
                pair.add(Math.max(i, complement));
                isCounted[i] = true;
                isCounted[complement] = true;
                result.add(pair);
            }
        }
        if (isTest) {
            System.out.println("isPrime:    " + Arrays.toString(isPrime));
            System.out.println("--------------------------------------------------------\nresult: ");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }
}