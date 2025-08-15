// Question: https://leetcode.com/problems/beautiful-arrangement/description/

class BeautifulArrangement {
    private int countArrangement;
    private int n;

    private void helper(int current, boolean[] isUsed) {
        // 1. Valid permutation found.
        if (current == n + 1) {
            countArrangement++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i] && (current % i == 0 || i % current == 0)) {
                isUsed[i] = true;
                helper(current + 1, isUsed);
                isUsed[i] = false;
            }
        }
    }

    public int countArrangement(int n) {
        countArrangement = 0;
        this.n = n;

        helper(1, new boolean[n + 1]);

        return countArrangement;
    }
}