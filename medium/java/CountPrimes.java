// Question: https://leetcode.com/problems/count-primes/description/

class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isP = new boolean[n + 1];
        boolean isTest = false;
        int c = 0;
        Arrays.fill(isP, true);

        // 0 and 1 are not prime numbers
        if (n > 0) {
            isP[0] = false;
            isP[1] = false;
        }
        if (isTest) {
            System.out.println(Arrays.toString(isP));
        }

        for (int i = 2; i * i <= n; i++) {
            if (isP[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isP[j] = false;
                }
            }
        }
        if (isTest) {
            System.out.println(Arrays.toString(isP));
        }
        for (int i = 0; i < n; i++) {
            if (isP[i]) {
                c++;
            }
        }
        return c;
    }

}
