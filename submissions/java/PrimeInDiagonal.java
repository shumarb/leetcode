// Question: https://leetcode.com/problems/prime-in-diagonal/description/

class PrimeInDiagonal {
    public int diagonalPrime(int[][] nums) {
        boolean isTest = false;
        int diagonalPrime = -1;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int number = nums[i][i];
            if (isPrime(number)) {
                diagonalPrime = Math.max(diagonalPrime, number);
            }
        }
        int row = 0;
        int column = len - 1;
        while (row < len && column >= 0) {
            int number = nums[row][column];
            if (isPrime(number)) {
                diagonalPrime = Math.max(diagonalPrime, number);
            }
            row++;
            column--;
        }

        return diagonalPrime == -1 ? 0 : diagonalPrime;
    }

    private boolean isPrime(int number) {
        // 1. Numbers less than 2 are not prime.
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}