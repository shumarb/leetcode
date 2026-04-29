// Question: https://leetcode.com/problems/pacific-atlantic-water-flow/description/

class Solution {
    private boolean[][] isAtlantic;
    private boolean[][] isPacific;
    private boolean isTest;
    private int[][] heights;
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        isTest = false;
        m = heights.length;
        n = heights[0].length;
        isAtlantic = new boolean[m][n];
        isPacific = new boolean[m][n];
        this.heights = heights;

        populate();
        if (isTest) {
            print();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bfs(i, j)) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        if (isTest) {
            System.out.println("----------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(e);
            }
        }

        return result;
    }

    private boolean bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[m][n];
        boolean canReachAtlantic = false;
        boolean canReachPacific = false;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        queue.offer(new int[] {i, j});
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] source = queue.poll();
                int column = source[1];
                int row = source[0];

                if (isPacific[row][column]) {
                    canReachPacific = true;
                }

                if (isAtlantic[row][column]) {
                    canReachAtlantic = true;
                }

                if (canReachAtlantic && canReachPacific) {
                    return true;
                }

                for (int[] direction: directions) {
                    int adjacentColumn = column + direction[1];
                    int adjacentRow = row + direction[0];

                    if (adjacentColumn < 0 || adjacentColumn >= n
                            || adjacentRow < 0 || adjacentRow >= m
                            || isVisited[adjacentRow][adjacentColumn]
                            || heights[adjacentRow][adjacentColumn] > heights[row][column]) {
                        continue;
                    }

                    queue.offer(new int[] {adjacentRow, adjacentColumn});
                    isVisited[adjacentRow][adjacentColumn] = true;
                }
            }
        }

        return canReachAtlantic && canReachPacific;
    }

    private void populate() {
        for (int i = 0; i < n; i++) {
            isPacific[0][i] = true;
        }

        for (int i = 0; i < m; i++) {
            isPacific[i][0] = true;
        }

        for (int i = 0; i < m; i++) {
            isAtlantic[i][n - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            isAtlantic[m - 1][i] = true;
        }
    }

    private void print() {
        System.out.println("heights");
        for (int[] row: heights) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nisAtlantic:");
        for (boolean[] row: isAtlantic) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nisPacific:");
        for (boolean[] row: isPacific) {
            System.out.println(Arrays.toString(row));
        }
    }
}
