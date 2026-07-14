// Question: https://leetcode.com/problems/pacific-atlantic-water-flow/description/

class PacificAtlanticWaterFlow {
    private int[][] directions;
    private int[][] heights;
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        m = heights.length;
        n = heights[0].length;
        boolean[][] isAtlantic = new boolean[m][n];
        boolean[][] isPacific = new boolean[m][n];
        boolean isTest = false;
        directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        this.heights = heights;

        for (int i = 0; i < m; i++) {
            dfs(isPacific, i, 0);
            dfs(isAtlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(isPacific, 0, j);
            dfs(isAtlantic, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isAtlantic[i][j] && isPacific[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        if (isTest) {
            System.out.println("heights:");
            for (int[] row: heights) {
                System.out.println(Arrays.toString(row));
            }

            System.out.println("\nisAtlantic: ");
            for (boolean[] row: isAtlantic) {
                System.out.println(Arrays.toString(row));
            }

            System.out.println("\nisPacific: ");
            for (boolean[] row: isPacific) {
                System.out.println(Arrays.toString(row));
            }

            System.out.println("------------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }

    private void dfs(boolean[][] isOceanReachable, int row, int column) {
        if (column < 0
                || column >= n
                || row < 0
                || row >= m
                || isOceanReachable[row][column]) {
            return;
        }

        isOceanReachable[row][column] = true;
        for (int[] direction: directions) {
            int nextColumn = column + direction[1];
            int nextRow = row + direction[0];

            if (nextColumn < 0
                    || nextColumn >= n
                    || nextRow < 0
                    || nextRow >= m
                    || isOceanReachable[nextRow][nextColumn]
                    || heights[nextRow][nextColumn] < heights[row][column]) {
                continue;
            }

            dfs(isOceanReachable, nextRow, nextColumn);
        }
    }
}
