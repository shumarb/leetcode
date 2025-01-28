// Question: https://leetcode.com/problems/power-of-two/description/

class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        boolean isTest = true;
        int count = 0;
        while (n != 0) {
            if (isTest) {
                System.out.println("current n: " + n);
            }
            if (n % 2 == 1) {
                count++;
            }
            if (count > 1) {
                return false;
            }
            n /= 2;
        }

        return true;
    }
}