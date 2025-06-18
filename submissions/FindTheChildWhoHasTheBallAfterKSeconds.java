// Question: https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds/description/

class FindTheChildWhoHasTheBallAfterKSeconds {
    public int numberOfChild(int n, int k) {
        boolean isIncrement = true;
        boolean isTest = false;
        int countCompletedCycles = 2 * (n - 1);
        int current = 0;

        if (isTest) {
            System.out.println("n: " + n + "\nk: " + k);
        }

        k %= countCompletedCycles;
        while (k-- > 0) {
            if (isIncrement) {
                current++;
            } else {
                current--;
            }
            if (current == 0) {
                isIncrement = true;
            } else if (current == n - 1) {
                isIncrement = false;
            }
        }
        if (isTest) {
            System.out.println("current: " + current);
        }

        return current;
    }
}