// Question: https://leetcode.com/problems/coin-change/description/

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // 1. Edge case: No amount.
        if (amount == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[amount + 1];
        boolean isTest = false;
        int totalCoins = 0;

        /**
         2.  Do BFS of all possible coin sums,
             and return level (total coins) where amount is formed.
         */
        queue.offer(0);
        isVisited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            totalCoins++;

            if (isTest) {
                System.out.println("------------------------------------");
                System.out.println("totalCoins: " + totalCoins + " -> queue: " + queue);
            }
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int coin: coins) {
                    int next = current + coin;
                    if (isTest) {
                        System.out.println(" * current: " + current + ", coin: " + coin + " -> next: " + next);
                    }
                    if (next == amount) {
                        if (isTest) {
                            System.out.println(" ** found: " + next + " -> total coins: " + totalCoins);
                        }
                        return totalCoins;

                    } else if (next < amount && !isVisited[next]) {
                        isVisited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return -1;
    }
}