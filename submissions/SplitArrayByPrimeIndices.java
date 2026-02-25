// Question: https://leetcode.com/problems/split-array-by-prime-indices/description/

class SplitArrayByPrimeIndices {
    public long splitArray(int[] nums) {
        boolean[] isPrime = new boolean[nums.length + 1];
        boolean isTest = false;
        int n = nums.length;
        long nonPrimeSum = 0l;
        long primeSum = 0l;
        long result = 0l;

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            long current = (long) nums[i];
            if (isPrime[i]) {
                primeSum += current;
            } else {
                nonPrimeSum += current;
            }
        }
        result = Math.abs(primeSum - nonPrimeSum);
        if (isTest) {
            System.out.println("isPrime: " + Arrays.toString(isPrime) );
            System.out.println("primeSum: " + primeSum + "\nnonPrimeSum: " + nonPrimeSum + "\nresult: " + result);
        }

        return result;
    }
}