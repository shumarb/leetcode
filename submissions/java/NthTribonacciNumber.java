// Question: https://leetcode.com/problems/n-th-tribonacci-number/description/

class NthTribonacciNumber {
    public int tribonacci(int n) {
        List<Integer> tribonacciNumbers = new ArrayList<>();
        tribonacciNumbers.add(0);
        tribonacciNumbers.add(1);
        tribonacciNumbers.add(1);

        if (n <= 2) {
            return tribonacciNumbers.get(n);
        }

        boolean isTest = false;
        while (tribonacciNumbers.size() < n + 1) {
            int size = tribonacciNumbers.size();
            int first = tribonacciNumbers.get(size - 3);
            int second = tribonacciNumbers.get(size - 2);
            int third = tribonacciNumbers.get(size - 1);
            tribonacciNumbers.add(first + second + third);
        }
        if (isTest) {
            System.out.println("tribonacci numbers: " + tribonacciNumbers);
        }

        return tribonacciNumbers.get(tribonacciNumbers.size() - 1);
    }
}