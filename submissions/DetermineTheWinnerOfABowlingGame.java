// Question: https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/description/

class DetermineTheWinnerOfABowlingGame {
    public int isWinner(int[] player1, int[] player2) {
        int player1Score = computeScore(player1);
        int player2Score = computeScore(player2);

        if (player1Score == player2Score) {
            return 0;
        } else if (player1Score > player2Score) {
            return 1;
        }
        return 2;
    }

    private int computeScore(int[] player) {
        int score = 0;
        for (int i = 0; i < player.length; i++) {
            if ((i - 1 >= 0 && player[i - 1] == 10) || (i - 2 >= 0 && player[i - 2] == 10)) {
                score += 2 * player[i];
            } else {
                score += player[i];
            }
        }
        return score;
    }
}