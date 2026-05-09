// Question: https://leetcode.com/problems/maximal-network-rank/description/

class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        // 1. Edge case: No connection between cities.
        if (roads.length == 0) {
            return 0;
        }

        boolean[][] isConnnected = new boolean[n][n];
        boolean isTest = false;
        int[] inDegree = new int[n];
        int result = 0;

        for (int[] road: roads) {
            int first = road[0];
            int second = road[1];

            inDegree[first]++;
            inDegree[second]++;
            isConnnected[first][second] = true;
            isConnnected[second][first] = true;
        }
        if (isTest) {
            System.out.println("inDegree: " + Arrays.toString(inDegree));
            System.out.println("isConnnected:");
            for (int i = 0; i < isConnnected.length; i++) {
                System.out.println(" * " + i + ": " + Arrays.toString(isConnnected[i]));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = inDegree[i] + inDegree[j];
                if (isConnnected[i][j]) {
                    rank--;
                }
                result = Math.max(rank, result);
            }
        }

        return result;
    }
}
