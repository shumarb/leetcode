// Question: https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/

class CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        boolean isTest = false;
        int[] remainders = new int[k];

        for (int e: arr) {
            int remainder = (e % k + k) % k;
            remainders[remainder]++;
        }
        if (isTest) {
            System.out.println("remainders: " + Arrays.toString(remainders));
        }

        /**
         1.  For numbers divisible by k, a valid pair can only be formed by these numbers,
             hence the frequency of numbers divisible by k must be even.
         */
        if (remainders[0] % 2 != 0) {
            return false;
        }

        /**
         2.  For two numbers not divisible by k, its remainders are r1 & k - r1.
             A pair can only be formed by numbers with these two remainders,
             hence the frequency of numbers with these remainders must be the same.
         */
        for (int i = 1; i < k; i++) {
            if (isTest) {
                System.out.println("--------------------------------------------------");
                System.out.println("r1: " + i + " -> remainder: " + remainders[i] + "\nr2: " + (k - i) + " -> remainder: " + remainders[k - i]);
            }
            if (remainders[i] != remainders[k - i]) {
                return false;
            }
        }

        return true;
    }
}