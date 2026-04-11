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
            display("before:\n");
        }
        dfs(sr, sc);
        if (isTest) {
            display("after:\n");
        }

        return image;
    }

    private void dfs(int row, int column) {
        if (row < 0 || column < 0 || row >= m || column >= n || isVisited[row][column] || image[row][column] != target) {
            return;
        }

        isVisited[row][column] = true;
        image[row][column] = color;

        dfs(row + 1, column);
        dfs(row - 1, column);
        dfs(row, column - 1);
        dfs(row, column + 1);
    }

    private void display(String s) {
        System.out.println(s);

        System.out.println("image:");
        for (int[] row: image) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nisVisited:");
        for (boolean[] row: isVisited) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("-----------------------------------");
    }
}
