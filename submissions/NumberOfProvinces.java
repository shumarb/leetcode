// Question: https://leetcode.com/problems/number-of-provinces/description/

class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int result = 0;
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i, isConnected, isVisited);
                result++;
            }
        }

        return result;
    }

    private void dfs(int vertex, int[][] isConnected, boolean[] isVisited) {
        isVisited[vertex] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[vertex][j] == 1 && !isVisited[j]) {
                dfs(j, isConnected, isVisited);
            }
        }
    }
}
