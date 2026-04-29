// Question: https://leetcode.com/problems/pacific-atlantic-water-flow/description/

class PacificAtlanticWaterFlow {
    private boolean[][] canReachAtlantic;
    private boolean[][] canReachPacific;
    private boolean[][] isVisited;
    private int[][] heights;
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        Queue<int[]> pacificQueue = new LinkedList<>();
        boolean isTest = false;
        m = heights.length;
        n = heights[0].length;
        canReachAtlantic = new boolean[m][n];
        canReachPacific = new boolean[m][n];
        isVisited = new boolean[m][n];
        this.heights = heights;

        for (int i = 0; i < m; i++) {
            canReachAtlantic[i][n - 1] = true;
            canReachPacific[i][0] = true;
            atlanticQueue.offer(new int[] {i, n - 1});
            pacificQueue.offer(new int[] {i, 0});
            isVisited[i][n - 1] = true;
            isVisited[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            canReachAtlantic[m - 1][j] = true;
            canReachPacific[0][j] = true;
            atlanticQueue.offer(new int[] {m - 1, j});
            pacificQueue.offer(new int[] {0, j});
            isVisited[m - 1][j] = true;
            isVisited[0][j] = true;
        }

        if (isTest) {
            System.out.println("heights: ");
            for (int[] row: heights) {
                System.out.println(Arrays.toString(row));
            }
            print("-----------------------------------\nbefore:");
        }

        bfs(atlanticQueue, 0);
        bfs(pacificQueue, 1);
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

    private void bfs(Queue<int[]> queue, int oceanCode) {
        boolean[][] isVisited = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] source = queue.poll();
            int column = source[1];
            int row = source[0];

            if (oceanCode == 0) {
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
