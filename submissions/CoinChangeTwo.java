// Question:

class CoinChangeTwo {
    public int change(int amount, int[] coins) {
        // 1. Edge case: 1 way to get amount of 0: not selecting any coins.
        if (amount == 0) {
            return 1;
        }

        boolean isTest = false;
        int[] dp = new int[amount + 1];

        // 2. Base case: 1 way to select 0 coins.
        dp[0] = 1;

        /**
         3.  Recurrence relation: dp[i] represents number of combinations
             of coins that sum to i.
         */
        for (int coin: coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        if (isTest) {
            System.out.println("dp: " + Arrays.toString(dp) + "\nresult: " + dp[amount]);
        }

        return dp[amount];
    }
}