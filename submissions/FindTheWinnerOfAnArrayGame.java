// Question: https://leetcode.com/problems/find-the-winner-of-an-array-game/description/

class FindTheWinnerOfAnArrayGame {
    public int getWinner(int[] arr, int k) {
        int winCount = 0;
        int winnerIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[winnerIndex] > arr[i]) {
                winCount++;
            } else {
                winCount = 1;
                winnerIndex = i;
            }

            if (winCount == k) {
                break;
            }
        }

        return arr[winnerIndex];
    }
}