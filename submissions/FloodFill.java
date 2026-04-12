// Question: https://leetcode.com/problems/flood-fill/description/

class FloodFill {
    private boolean[][] isVisited;
    private int[][] image;
    private int color;
    private int m;
    private int n;
    private int target;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean isTest = false;
        m = image.length;
        n = image[0].length;
        isVisited = new boolean[m][n];
        target = image[sr][sc];
        this.color = color;
        this.image = image;

        if (isTest) {
            display("before:");
        }
        dfs(sr, sc);
        if (isTest) {
            display("\nafter:");
        }

        return image;
    }

    private void dfs(int row, int column) {
        if (row < 0 || column < 0 || row >= m || column >= n || isVisited[row][column] || image[row][column] != target) {
            return;
        }

        image[row][column] = color;
        isVisited[row][column] = true;

        dfs(row - 1, column);
        dfs(row + 1, column);
        dfs(row, column - 1);
        dfs(row, column + 1);
    }

    private void display(String s) {
        System.out.println(s);
        for (int[] row: image) {
            System.out.println(Arrays.toString(row));
        }
    }
}
