// Question: https://leetcode.com/problems/calculate-score-after-performing-instructions/description/

class CalculateScoreAfterPerformingInstructions {
    public long calculateScore(String[] instructions, int[] values) {
        int i = 0;
        int n = values.length;
        boolean[] isIndexVisited = new boolean[n];
        long score = 0;

        while (i >= 0 && i < n && !isIndexVisited[i]) {
            isIndexVisited[i] = true;

            if (instructions[i].charAt(0) == 'a') {
                score += values[i++];

            } else {
                i += values[i];
            }
        }

        return score;
    }
}