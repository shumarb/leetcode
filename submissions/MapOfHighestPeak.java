// Question: https://leetcode.com/problems/map-of-highest-peak/description/

class MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean isTest = false;
        int m = isWater.length;
        int n = isWater[0].length;

        /**
         1.  If a cell is water, it's final value is 0,
             else mark it as -1 to indicate it final value must be computed.
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    queue.offer(new int[] {i, j});
                } else {
                    isWater[i][j] = -1;
                }
            }
        }
        if (isTest) {
            print("before, result: ", isWater);
        }

        /**
         2.  If a point's value != -1, this value represents the distance of the point to its nearest water cell.
         For each of its adjacent cells whose value is -1, the distance between point and its adjacent cell is 1,
         hence the distance of this adjacent cell to its nearest water cell is (1 + distance of point to its nearest water cell).
         */
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int column = cell[1];
            int row = cell[0];

            for (int[] direction: directions) {
                int adjacentColumn = column + direction[1];
                int adjacentRow = row + direction[0];

                if (adjacentColumn < 0 || adjacentRow < 0 || adjacentRow >= m || adjacentColumn >= n) {
                    continue;
                }

                if (isWater[adjacentRow][adjacentColumn] == -1) {
                    isWater[adjacentRow][adjacentColumn] = 1 + isWater[row][column];
                    queue.offer(new int[] {adjacentRow, adjacentColumn});
                }
            }
        }
        if (isTest) {
            print("after, result: ", isWater);
        }

        return isWater;
    }

    private void print(String s, int[][] grid) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------------------------------");
    }
}
