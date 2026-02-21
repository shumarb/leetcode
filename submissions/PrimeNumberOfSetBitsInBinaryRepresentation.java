// Question: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/?envType=problem-list-v2&envId=math

class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {
        boolean[] isPrime = new boolean[] {
                false, false, true, true, false, true,
                false, true, false, false, false, true,
                false, true, false, false, false, true,
                false, true
        };
        boolean isTest = false;
        int result = 0;

        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if (isPrime[setBits]) {
                if (isTest) {
                    System.out.println(" * valid: " + i + " -> " + setBits);
                }
                result++;
            }
        }

        return result;
    }
}