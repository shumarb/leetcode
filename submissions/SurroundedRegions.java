// Question: https://leetcode.com/problems/surrounded-regions/description/

class SurroundedRegions class Solution {
    private List<int[]> component;
    private boolean[][] isVisited;
    private char[][] board;
    private int m;
    private int n;

    public void solve(char[][] board) {
        boolean isTest = false;
        component = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        isVisited = new boolean[m][n];
        this.board = board;

        // 1. Edge case: single element.
        if (m == 1 && n == 1) {
            return;
        }

        if (isTest) {
            print("before:\n\nboard");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' || isVisited[i][j]) {
                    continue;
                }

                dfs(i, j);
                if (isTest) {
                    System.out.print("component: ");
                    for (int[] point: component) {
                        System.out.print(Arrays.toString(point) + " ");
                    }
                    System.out.println();
                }

                boolean isValid = true;
                for (int[] point: component) {
                    int column = point[1];
                    int row = point[0];

                    if (column == 0 || column == n - 1 || row == 0 || row == m - 1) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    for (int[] point: component) {
                        board[point[0]][point[1]] = 'X';
                    }
                }
                component.clear();
            }
        }
        if (isTest) {
            print("-------------------------------\nafter:\n\nboard");
        }
    }

    private void dfs(int row, int column) {
        if (row < 0 || column < 0 || row >= m || column >= n || isVisited[row][column] || board[row][column] == 'X') {
            return;
        }

        component.add(new int[] {row, column});
        isVisited[row][column] = true;

        dfs(row - 1, column);
        dfs(row + 1, column);
        dfs(row, column - 1);
        dfs(row, column + 1);
    }

    private void print(String s) {
        System.out.println(s);
        for (char[] row: board) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nisVisited:");
        for (boolean[] row: isVisited) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------------------------");
    }
}
