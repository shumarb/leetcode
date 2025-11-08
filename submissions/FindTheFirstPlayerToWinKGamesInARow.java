// Question: https://leetcode.com/problems/find-the-first-player-to-win-k-games-in-a-row/description/

class FindTheFirstPlayerToWinKGamesInARow {
    public int findWinningPlayer(int[] skills, int k) {
        int winCount = 0;
        int winningIndex = 0;

        for (int i = 1; i < skills.length; i++) {
            if (skills[winningIndex] > skills[i]) {
                winCount++;
            } else {
                winningIndex = i;
                winCount = 1;
            }

            if (winCount == k) {
                return winningIndex;
            }
        }

        return winningIndex;
    }
}