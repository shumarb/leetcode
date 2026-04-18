// Question: https://leetcode.com/problems/word-search/description/

class WordSearch {
    private boolean isExist;
    private boolean isTest;
    private char[][] board;
    private int index;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        index = 0;
        isTest = false;
        m = board.length;
        n = board[0].length;
        this.board = board;

        if (isTest) {
            print("word: " + word + "\nboard:");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }

                index = 0;
                isExist = false;
                dfs(i, j, word.toCharArray());
                if (isExist) {
                    return true;
                }
            }
        }

        return false;
    }

    private void dfs(int row, int column, char[] letters) {
        // 1. Invalid for non-existent cell, visited cell, or invalid index.
        if (column < 0 || column >= n || row < 0 || row >= m || board[row][column] == '!' || index >= letters.length) {
            return;
        }

        // 2. Reach last letter of word, so a path exists.
        if (index == letters.length - 1) {
            if (isTest) {
                print("found | path:");
            }
            isExist = true;
            return;
        }

        // 3. Mark cell as visited, explore adjacent cells.
        char initialLetter = board[row][column];
        board[row][column] = '!';
        index++;

        if (isTest) {
            System.out.println("current: [" + row + ", " + column + "] | next index: " + index);
        }
        if (row - 1 >= 0 && board[row - 1][column] == letters[index]) {
            dfs(row - 1, column, letters);
        }
        if (row + 1 < m && board[row + 1][column] == letters[index]) {
            dfs(row + 1, column, letters);
        }
        if (column - 1 >= 0 && board[row][column - 1] == letters[index]) {
            dfs(row, column - 1, letters);
        }
        if (column + 1 < n && board[row][column + 1] == letters[index]) {
            dfs(row, column + 1, letters);
        }

        // 5. When backtracking, a path may have been found, so no need to explore further.
        if (isExist) {
            return;
        }

        // 6. Current path does not lead to all letters, and valid path not found yet,
        // so backtrack and explore next path.
        board[row][column] = initialLetter;
        index--;
    }

    private void print(String s) {
        System.out.println(s);
        for (char[] row: board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-----------------------------------");
    }
}
