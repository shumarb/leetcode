// Question: https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[] deltaRows =    new int[] {-1, -1, 0, 1, 1,  1, 0,  -1};
        int[] deltaColumns = new int[] {0,   1, 1, 1, 0, -1, -1, -1};
        int level = 0;
        int n = grid.length;
        boolean[][] isVisited = new boolean[n][n];
        boolean isTest = false;

        if (isTest) {
            System.out.println("source: " + Arrays.toString(new int[] {0, 0}) + ", destination: " + Arrays.toString(new int[] {n - 1, n - 1}));
            System.out.println("\ngrid:");
            for (int[] row: grid) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("------------------------------");
        }

        // 1. Edge case: Impossible to start at top-left cell or reach bottom-right cell.
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        queue.offer(new int[] {0, 0});
        level++;
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("level: " + level + "\n\nqueue:");
                for (int[] coordinate: queue) {
                    System.out.println(Arrays.toString(coordinate));
                }
                System.out.println("------------------------------");
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int column = top[1];
                int row = top[0];

                if (row == n - 1 && column == n - 1) {
                    if (isTest) {
                        System.out.println(" ** found @ level " + level);
                    }
                    return level;
                }

                isVisited[row][column] = true;

                for (int j = 0; j < deltaRows.length; j++) {
                    int neighbourColumn = column + deltaColumns[j];
                    int neighbourRow = row + deltaRows[j];

                    if (neighbourRow >= 0 && neighbourRow < n
                            && neighbourColumn >= 0 && neighbourColumn < n
                            && grid[neighbourRow][neighbourColumn] == 0
                            && !isVisited[neighbourRow][neighbourColumn]
                    ) {
                        int[] coordinate = new int[] {neighbourRow, neighbourColumn};
                        isVisited[neighbourRow][neighbourColumn] = true;
                        queue.offer(coordinate);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
