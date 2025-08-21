// Question: https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/

class MaximumMatchingOfPlayersWithTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int countMatches = 0;
        int i = 0;
        int j = 0;

        Arrays.sort(players);
        Arrays.sort(trainers);
        while (i < players.length && j < trainers.length) {
            if (trainers[j] >= players[i]) {
                countMatches++;
                i++;
            }
            j++;
        }

        return countMatches;
    }
}