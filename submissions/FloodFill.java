// Question: https://leetcode.com/problems/flood-fill/description/

class FloodFill {
    private boolean[][] isVisited;
    private int[][] image;
    private int key;
    private int m;
    private int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean isTest = false;
        m = image.length;
        n = image[0].length;
        isVisited = new boolean[m][n];
        key = image[sr][sc];
        this.image = image;

        if (isTest) {
            System.out.println("start @ [" + sr + ", " + sc + "]" + "\nconvert " + image[sr][sc] + " -> " + color);
            print("before:");
        }
        dfs(sr, sc, color);
        if (isTest) {
            print("after:");
        }

        return image;
    }

    private void dfs(int row, int column, int color) {
        if (row < 0 || row >= m || column < 0 || column >= n || isVisited[row][column] || image[row][column] != key) {
            return;
        }

        image[row][column] = color;
        isVisited[row][column] = true;

        dfs(row - 1, column, color);
        dfs(row + 1, column, color);
        dfs(row, column - 1, color);
        dfs(row, column + 1, color);
    }

    private void print(String s) {
        System.out.println(s);
        for (int[] row: image) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----------------------");
    }
}
