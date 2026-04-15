// Question: https://leetcode.com/problems/rotting-oranges/description/

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean isTest = false;
        int countFreshOranges = 0;
        int level = -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    countFreshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                    isVisited[i][j] = true;
                }
            }
        }

        // 1. Edge case: Grid only has empty cells.
        if (countFreshOranges == 0 && queue.isEmpty()) {
            return 0;
        }

        if (isTest) {
            print("initial countFreshOranges: " + countFreshOranges + "\n\nbefore:", grid, isVisited);
            System.out.println("----------------------------");
        }
        while (!queue.isEmpty()) {
            if (isTest) {
                print("level: " + level + "\nqueue: ", queue, grid);
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int column = top[1];
                int row = top[0];

                for (int[] direction: directions) {
                    int adjacentColumn = column + direction[1];
                    int adjacentRow = row + direction[0];

                    if (adjacentColumn < 0 || adjacentColumn >= n
                            || adjacentRow < 0 || adjacentRow >= m
                            || isVisited[adjacentRow][adjacentColumn] || grid[adjacentRow][adjacentColumn] != 1) {
                        continue;
                    }

                    grid[adjacentRow][adjacentColumn] = 2;
                    countFreshOranges--;
                    isVisited[adjacentRow][adjacentColumn] = true;
                    queue.offer(new int[] {adjacentRow, adjacentColumn});
                }
            }

            level++;
        }
        if (isTest) {
            print("----------------------------\nfinal countFreshOranges: " + countFreshOranges + "\nlevel: " + level + "\n\nafter:", grid, isVisited);
        }

        return countFreshOranges == 0 ? level : -1;
    }

    private void print(String s, int[][] grid, boolean[][] isVisited) {
        System.out.println(s);
        for (int[] point: grid) {
            System.out.println(" * " + Arrays.toString(point));
        }
        System.out.println("\nisVisited:");
        for (boolean[] row: isVisited) {
            System.out.println(" * " + Arrays.toString(row));
        }
    }

    private void print(String s, Queue<int[]> queue, int[][] grid) {
        System.out.println(s);
        for (int[] point: queue) {
            System.out.println(" * " + Arrays.toString(point));
        }
        System.out.println();
    }
}
