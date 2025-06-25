// Question: https://leetcode.com/problems/find-the-winning-player-in-coin-game/description/

class FindTheWinningPlayerInCoinGame {
    public String winningPlayer(int x, int y) {
        int count = 0;
        while (x >= 0 && y >= 0) {
            x -= 1;
            y -= 4;
            count++;
        }
        return count % 2 == 0 ? "Alice" : "Bob";
    }
}