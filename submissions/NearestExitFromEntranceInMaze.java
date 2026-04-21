// Question: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/

class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = maze.length;
        int n = maze[0].length;
        int level = 0;
        boolean[][] isVisited = new boolean[m][n];
        boolean isTest = false;

        queue.offer(entrance);
        isVisited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            if (isTest) {
                print("level: " + level + "\n\nqueue:", queue);
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int column = top[1];
                int row = top[0];

                if (level != 0 && (row == 0 || row == m - 1 || column == 0 || column == n - 1)) {
                    if (isTest) {
                        System.out.println(" ** found valid exit @ " + level);
                    }
                    return level;
                }

                for (int[] direction: directions) {
                    int adjacentColumn = column + direction[1];
                    int adjacentRow = row + direction[0];

                    if (adjacentColumn < 0 || adjacentColumn >= n || adjacentRow < 0 || adjacentRow >= m
                            || isVisited[adjacentRow][adjacentColumn] || maze[adjacentRow][adjacentColumn] != '.') {
                        continue;
                    }

                    queue.offer(new int[] {adjacentRow, adjacentColumn});
                    isVisited[adjacentRow][adjacentColumn] = true;
                }
            }

            level++;
        }

        return -1;
    }

    private void print(String s, Queue<int[]> queue) {
        System.out.println(s);
        for (int[] e: queue) {
            System.out.println(Arrays.toString(e));
        }
        System.out.println("-----------------------------------------------");
    }
}
