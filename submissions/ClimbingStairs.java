// Question: https://leetcode.com/problems/climbing-stairs/description/

class ClimbingStairs {
    public int climbStairs(int n) {
        boolean isTest = false;
        int[] count = new int[n + 1];

        // 1. 1 way to climb 0 ste
        count[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0) {
                count[i] += count[i - 1];
            }
            if (i - 2 >= 0) {
                count[i] += count[i - 2];
            }
        }
        if (isTest) {
            System.out.println("count: " + Arrays.toString(count) + "\nresult: " + count[n]);
        }

        return count[n];
    }
}
