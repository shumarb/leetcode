// Question: https://leetcode.com/problems/happy-number/description/

class HappyNumber {
    public boolean isHappy(int n) {
        int sum = 0;
        boolean t = false;
        while (n > 0) {
            if (t) {
                System.out.println("n: " + n + " | sum: " + sum);
            }
            sum += (n % 10) * (n % 10);
            n /= 10;
            if (n == 0) {
                if (t) {
                    System.out.println("n: " + n + " | sum: " + sum);
                }
                if (sum < 9) {
                    break;
                } else {
                    n = sum;
                    sum = 0;
                }
            }
        }
        if (t) {
            System.out.println("sum: " + sum);
        }
        return sum == 1 || sum == 7;
    }
}