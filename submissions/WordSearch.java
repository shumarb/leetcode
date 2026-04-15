// Question: https://leetcode.com/problems/word-search/description/

class WordSearch {
    private boolean isFound;
    private boolean isTest;
    private char[][] board;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        isFound = false;
        isTest = false;
        m = board.length;
        n = board[0].length;
        this.board = board;

        if (isTest) {
            System.out.println("board:");
            for (char[] row: board) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("------------------------------------");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }

                /**
                 1.  Only start at cell starting from first letter
                 to avoid running redundant searches.
                 */
                dfs(i, j, 0, word, new boolean[m][n]);
                if (isFound) {
                    return true;
                }
            }
        }

        return false;
    }

    private void dfs(int row, int column, int index, String word, boolean[][] isVisited) {
        if (index >= word.length()
                || column < 0 || column >= n || row < 0 || row >= m
                || isVisited[row][column] || board[row][column] != word.charAt(index)) {
            return;
        }

        if (isTest) {
            System.out.println("current: [" + row + ", " + column + "] | index: " + index);
        }

        isVisited[row][column] = true;

        // 2. Path exists to form word.
        if (index == word.length() - 1) {
            isFound = true;
            return;
        }

        dfs(row - 1, column, index + 1, word, isVisited);
        dfs(row + 1, column, index + 1, word, isVisited);
        dfs(row, column - 1, index + 1, word, isVisited);
        dfs(row, column + 1, index + 1, word, isVisited);

        // 3. Backtrack and explore next path.
        isVisited[row][column] = false;
    }
}
