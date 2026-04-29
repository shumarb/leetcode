// Question: https://leetcode.com/problems/pacific-atlantic-water-flow/description/

class PacificAtlanticWaterFlow {
    private int[][] heights;
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        Queue<int[]> pacificQueue = new LinkedList<>();
        m = heights.length;
        n = heights[0].length;
        boolean[][] canReachAtlantic = new boolean[m][n];
        boolean[][] canReachPacific = new boolean[m][n];
        boolean isTest = false;
        this.heights = heights;

        for (int i = 0; i < m; i++) {
            atlanticQueue.offer(new int[] {i, n - 1});
            pacificQueue.offer(new int[] {i, 0});
        }
        for (int j = 0; j < n; j++) {
            atlanticQueue.offer(new int[] {m - 1, j});
            pacificQueue.offer(new int[] {0, j});
        }

        if (isTest) {
            System.out.println("heights: ");
            for (int[] row: heights) {
                System.out.println(Arrays.toString(row));
            }
            print("-----------------------------------\nbefore:", canReachAtlantic, canReachPacific);
        }

        bfs(atlanticQueue, canReachAtlantic);
        bfs(pacificQueue, canReachPacific);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachAtlantic[i][j] && canReachPacific[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        if (isTest) {
            print("-----------------------------------\nafter:", canReachAtlantic, canReachPacific);
            System.out.println("\n-----------------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(e);
            }
        }

        return result;
    }

    private void bfs(Queue<int[]> queue, boolean[][] isVisited) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] source = queue.poll();
            int column = source[1];
            int row = source[0];

            isVisited[row][column] = true;

            for (int[] direction: directions) {
                int adjacentColumn = column + direction[1];
                int adjacentRow = row + direction[0];

                if (adjacentColumn < 0 || adjacentColumn >= n
                        || adjacentRow < 0 || adjacentRow >= m
                        || isVisited[adjacentRow][adjacentColumn]
                        || heights[adjacentRow][adjacentColumn] < heights[row][column]) {
                    continue;
                }

                queue.offer(new int[] {adjacentRow, adjacentColumn});
            }
        }
    }

    private void print(String s, boolean[][] canReachAtlantic, boolean[][] canReachPacific) {
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
