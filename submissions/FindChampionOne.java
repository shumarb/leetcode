// Question: https://leetcode.com/problems/find-champion-i/description/

class FindChampionOne {
    public int findChampion(int[][] grid) {
        boolean isTest = false;
        int champion = 0;
        int maximumScore = 0;
        int n = grid.length;
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || grid[i][j] == 0) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    score[i]++;
                } else {
                    score[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (isTest) {
                System.out.println(" * i: " + i + " -> compare | score: " + score[i] + ", maximumScore: " + maximumScore);
            }
            if (score[i] > maximumScore) {
                champion = i;
                maximumScore = score[i];
            }
        }
        if (isTest) {
            System.out.println("score: " + Arrays.toString(score) + "\nmaximumScore: " + maximumScore + "\nchampion: " + champion);
        }

        return champion;
    }
}