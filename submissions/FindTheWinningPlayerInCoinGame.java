// Question: https://leetcode.com/problems/find-the-winning-player-in-coin-game/description/

class FindTheWinningPlayerInCoinGame {
    public String winningPlayer(int x, int y) {
        int parity = Math.min(x, y / 4);
        return parity % 2 == 0 ? "Bob" : "Alice";
    }
}