// Question: https://leetcode.com/problems/find-the-number-of-winning-players/description/

class FindTheNumberOfWinningPlayers {
    public int winningPlayerCount(int n, int[][] pick) {
        int countWinningPlayers = 0;
        boolean isTest = false;
        int maximum = 0;

        for (int[] entry: pick) {
            maximum = Math.max(maximum, entry[1]);
        }
        int[][] picksPerPlayer = new int[n][maximum + 1];

        for (int[] entry: pick) {
            int player = entry[0];
            int ballColour = entry[1];
            picksPerPlayer[player][ballColour]++;
        }
        if (isTest) {
            int i = 0;
            for (int[] entry: picksPerPlayer) {
                System.out.println(i++ + ": " + Arrays.toString(entry));
            }
        }

        int i = 0;
        for (int[] entry: picksPerPlayer) {
            if (isWinningPlayer(i, entry)) {
                if (isTest) {
                    System.out.println("winning player: " + i);
                }
                countWinningPlayers++;
            }
            i++;
        }

        return countWinningPlayers;
    }

    private boolean isWinningPlayer(int player, int[] ballColours) {
        for (int ballColour: ballColours) {
            if (ballColour >= player + 1) {
                return true;
            }
        }
        return false;
    }
}