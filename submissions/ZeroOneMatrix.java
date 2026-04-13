// Question: https://leetcode.com/problems/01-matrix/description/

class ZeroOneMatrix class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean isTest = false;
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
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int column = top[1];
            int row = top[0];

            for (int[] direction: directions) {
                int adjacentColumn = column + direction[1];
                int adjacentRow = row + direction[0];

                if (adjacentColumn < 0 || adjacentRow < 0 || adjacentColumn >= n || adjacentRow >= m) {
                    continue;
                }

                /**
                 1.  Dequeued cells with an element value != -1 mean the dequeued cell is [element] distance away from its closest 0.
                     Since adjacentRow and adjacentColumn are cells of distance 1 from the dequeued cell,
                     it is [1 + element] distance away from its closest cell.
                 */
                if (mat[adjacentRow][adjacentColumn] == -1) {
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
        System.out.println("-----------------------------");
    }
}
