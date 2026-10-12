// Question: https://leetcode.com/problems/three-fibonacci-sum/description/

class ThreeFibonacciSum {
    public boolean threeFibonacciSum(int n) {
        int a = 0;
        int b = 1;

        while (a + b <= n) {
            int c = a + b;

            if (a + b + c == n) {
                return true;
            }

            a = b;
            b = c;
        }

        return false;
    }
}
