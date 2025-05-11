// Question: https://leetcode.com/problems/three-divisors/description/

class ThreeDivisors {
    public boolean isThree(int n) {
        if (n <= 3) {
            return false;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isDivisible(n, i)) {
                count++;
            }
        }
        return count == 3;
    }

    private boolean isDivisible(int n, int d) {
        boolean isTest = false;
        if (isTest) {
            System.out.println("check | n: " + n + ", d: " + d);
        }
        return n % d == 0;
    }
}