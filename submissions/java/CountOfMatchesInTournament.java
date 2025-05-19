// Question: https://leetcode.com/problems/count-of-matches-in-tournament/description/

class CountOfMatchesInTournament {
    public int numberOfMatches(int n) {
        int countMatches = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                countMatches += (n / 2);
                n /= 2;
            } else {
                countMatches += (n - 1) / 2;
                n = ((n - 1) / 2) + 1;
            }
        }
        return countMatches;
    }
}