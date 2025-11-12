// Question: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/

class PairOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        long[] count = new long[60];
        long result = 0;

        for (int e: time) {
            count[e % 60]++;
        }

        result += count[0] * (count[0] - 1) / 2;
        result += count[30] * (count[30] - 1) / 2;
        for (int i = 1; i < 30; i++) {
            result += count[i] * count[60 - i];
        }

        return (int) result;
    }
}