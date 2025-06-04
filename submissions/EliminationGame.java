// Question: https://leetcode.com/problems/elimination-game/description/

class EliminationGame {
    public int lastRemaining(int n) {
        return (n == 1) ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}