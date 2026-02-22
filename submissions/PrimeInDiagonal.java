// Question: https://leetcode.com/problems/prime-in-diagonal/description/

class PrimeInDiagonal {
    public int diagonalPrime(int[][] nums) {
        boolean isTest = false;
        int diagonalPrime = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int number = nums[i][i];
            // 1. Numbers 0 and 1 are no-prime so skip it.
            if (number >= 2 && isPrime(number)) {
                diagonalPrime = Math.max(diagonalPrime, number);
            }
            number = nums[i][n - i - 1];
            if (number >= 2 && isPrime(number)) {
                diagonalPrime = Math.max(diagonalPrime, number);
            }
        }

        return diagonalPrime;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}