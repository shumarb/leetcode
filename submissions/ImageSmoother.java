// Question: https://leetcode.com/problems/image-smoother/description/

class Solution {
    public int[][] imageSmoother(int[][] img) {
        boolean isTest = false;
        int m = img.length;
        int n = img[0].length;
        int[][] directions = {
                {-1, 0}, {-1, -1},
                {0, 1}, {1, 1},
                {1, 0}, {1, -1},
                {0, -1}, {-1, 1}
        };
        int[][] result = new int[m][n];

        if (isTest) {
            print("img:", img);
        }

        // 1. Edge case: single row and single column.
        if (m == 1 && n == 1) {
            return img;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int total = img[i][j];
                int count = 1;

                for (int[] direction: directions) {
                    int adjacentColumn = j + direction[1];
                    int adjacentRow = i + direction[0];

                    if (adjacentColumn < 0 || adjacentColumn >= n || adjacentRow < 0 || adjacentRow >= m) {
                        continue;
                    }

                    total += img[adjacentRow][adjacentColumn];
                    count++;
                }
                if (isTest) {
                    System.out.println(" * [" + i + ", " + j + "] | element: " + img[i][j] + "  | total: " + total + ", count: " + count);
                }
                result[i][j] = total / count;
            }
        }
        if (isTest) {
            print("------------------------------------------------------------\nresult:", result);
        }

        return result;
    }

    private void print(String s, int[][] grid) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------------------------------------------------");
    }
}
