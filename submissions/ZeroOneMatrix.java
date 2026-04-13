// Question: https://leetcode.com/problems/01-matrix/description/

class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        boolean isTest = false;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int INF = Integer.MAX_VALUE;
        int m = mat.length;
        int n = mat[0].length;

        if (isTest) {
            print("before:", mat);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    mat[i][j] = INF;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int column = point[1];
            int row = point[0];

            for (int[] direction: directions) {
                int adjacentColumn = column + direction[1];
                int adjacentRow = row + direction[0];

                if (adjacentRow < 0 || adjacentColumn < 0 || adjacentColumn >= n || adjacentRow >= m) {
                    continue;
                }

                if (mat[adjacentRow][adjacentColumn] == INF) {
                    mat[adjacentRow][adjacentColumn] = 1 + mat[row][column];
                    queue.offer(new int[] {adjacentRow, adjacentColumn});
                }
            }
        }
        if (isTest) {
            print("after:", mat);
        }

        return mat;
    }

    private void print(String s, int[][] mat) {
        System.out.println(s);
        for (int[] row: mat) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----------------------------------");
    }
}
