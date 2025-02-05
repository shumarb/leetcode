// Question: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/?envType=problem-list-v2&envId=math

class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {
        int totalPrimeNumberSetBits = 0;

        for (int i = left; i <= right; i++) {
            int numOfOneBits = getNumberOfOneBits(i);
            if (isPrime(numOfOneBits)) {
                totalPrimeNumberSetBits++;
            }
        }

        return totalPrimeNumberSetBits;
    }

    private boolean isPrime(int numberOfOneBits) {
        if (numberOfOneBits == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numberOfOneBits); i++) {
            if (numberOfOneBits % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int getNumberOfOneBits(int number) {
        int numberOfOneBits = 0;

        while (number != 0) {
            if (number % 2 == 1) {
                numberOfOneBits++;
            }
            number /= 2;
        }

        return numberOfOneBits;
    }
}