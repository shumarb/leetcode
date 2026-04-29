// Question: https://leetcode.com/problems/pacific-atlantic-water-flow/description/

class PacificAtlanticWaterFlow {
    private boolean[][] canReachAtlantic;
    private boolean[][] canReachPacific;
    private int[][] heights;
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;
        m = heights.length;
        n = heights[0].length;
        canReachAtlantic = new boolean[m][n];
        canReachPacific = new boolean[m][n];
        this.heights = heights;

        for (int i = 0; i < m; i++) {
            canReachAtlantic[i][n - 1] = true;
            canReachPacific[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            canReachAtlantic[m - 1][j] = true;
            canReachPacific[0][j] = true;
        }

        if (isTest) {
            System.out.println("heights: ");
            for (int[] row: heights) {
                System.out.println(Arrays.toString(row));
            }
            print("-----------------------------------\nbefore:");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    bfs(i, j, "pacific");
                }

                if (i == m - 1 || j == n - 1) {
                    bfs(i, j, "atlantic");
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachAtlantic[i][j] && canReachPacific[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        if (isTest) {
            print("-----------------------------------\nafter:");
            System.out.println("\n-----------------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(e);
            }
        }

        return result;
    }

    private void bfs(int i, int j, String ocean) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        queue.offer(new int[] {i, j});
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] source = queue.poll();
            int column = source[1];
            int row = source[0];

            if (ocean.equals("atlantic")) {
                canReachAtlantic[row][column] = true;
            } else {
                canReachPacific[row][column] = true;
            }

            for (int[] direction: directions) {
                int adjacentColumn = column + direction[1];
                int adjacentRow = row + direction[0];

                if (adjacentColumn < 0 || adjacentColumn >= n
                        || adjacentRow < 0 || adjacentRow >= m
                        || isVisited[adjacentRow][adjacentColumn] || heights[adjacentRow][adjacentColumn] < heights[row][column]) {
                    continue;
                }

                queue.offer(new int[] {adjacentRow, adjacentColumn});
                isVisited[adjacentRow][adjacentColumn] = true;
            }
        }
    }

    private void print(String s) {
        System.out.println(s);
        System.out.println("\ncanReachAtlantic:");
        for (boolean[] row: canReachAtlantic) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\ncanReachPacific:");
        for (boolean[] row: canReachPacific) {
            System.out.println(Arrays.toString(row));
        }
    }
}
