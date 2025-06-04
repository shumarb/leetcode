// Question: https://leetcode.com/problems/n-th-tribonacci-number/description/

class NthTribonacciNumber {
    public int tribonacci(int n) {
        int[] tribonacciNumbers = new int[38];
        tribonacciNumbers[1] = 1;
        tribonacciNumbers[2] = 1;

        if (n <= 2) {
            return tribonacciNumbers[n];
        }
        for (int i = 3; i <= n; i++) {
            tribonacciNumbers[i] = tribonacciNumbers[i - 3] + tribonacciNumbers[i - 2] + tribonacciNumbers[i - 1];
        }

        return tribonacciNumbers[n];
    }
}