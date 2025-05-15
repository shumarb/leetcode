// Question: https://leetcode.com/problems/prime-in-diagonal/description/

class PrimeInDiagonal {
    public int diagonalPrime(int[][] nums) {
        boolean isTest = false;
        int diagonalPrime = -1;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int number = nums[i][i];
            // 1. Numbers 0 and 1 are no-prime so skip it.
            if (number >= 2 && isPrime(number)) {
                diagonalPrime = Math.max(diagonalPrime, number);
            }
        }
        int row = 0;
        int column = len - 1;
        while (row < len && column >= 0) {
            int number = nums[row][column];
            if (number >= 2 && isPrime(number)) {
                diagonalPrime = Math.max(diagonalPrime, number);
            }
            row++;
            column--;
        }

        return diagonalPrime == -1 ? 0 : diagonalPrime;
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