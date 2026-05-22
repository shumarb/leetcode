// Question: https://leetcode.com/problems/jump-game-vii/description/

class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] steps = s.toCharArray();
        int count = 0;
        int n = s.length();
        boolean isTest = false;
        boolean[] dp = new boolean[n];

        dp[0] = true;

        // 1. For each step, count the number of ways
        //    to jump from last 0 to next 0 within [minJump, maxJump] jumps.
        for (int i = 0; i < s.length(); i++) {
            if (i >= minJump && dp[i - minJump]) {
                count++;
            }
            if (i > maxJump && dp[i - maxJump - 1]) {
                count--;
            }

            if (steps[i] == '0' && count > 0) {
                dp[i] = true;
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\ndp: " + Arrays.toString(dp));
        }

        return dp[n - 1];
    }
}
