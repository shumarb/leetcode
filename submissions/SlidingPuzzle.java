// Question: https://leetcode.com/problems/sliding-puzzle/description/

class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        Queue<int[][]> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        boolean isTest = false;
        int result = 0;

        queue.offer(board);
        isVisited.add(getKey(board));

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("------------------------\nlevel " + result + ":");
                for (int[][] e: queue) {
                    for (int i = 0; i < e.length; i++) {
                        for (int j = 0; j < e[0].length; j++) {
                            System.out.print(" " + e[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }

            int size = queue.size();
            while (size-- > 0) {
                int[][] top = queue.poll();

                if (isValid(top)) {
                    if (isTest) {
                        System.out.println(" * found @ level " + result);
                    }

                    return result;
                }

                for (int[][] next: getNext(top, isVisited)) {
                    queue.offer(next);
                }
            }

            result++;
        }

        return -1;
    }

    private boolean isValid(int[][] grid) {
        return grid[0][0] == 1
                && grid[0][1] == 2
                && grid[0][2] == 3
                && grid[1][0] == 4
                && grid[1][1] == 5
                && grid[1][2] == 0;
    }

    private List<int[][]> getNext(int[][] board, Set<String> isVisited) {
        List<int[][]> result = new ArrayList<>();
        int column = 0;
        int row = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    column = j;
                    row = i;
                    break;
                }
            }
        }

        if (row - 1 >= 0) {
            getNext(result, isVisited, board, row, column, row - 1, column);
        }

        if (row + 1 < board.length) {
            getNext(result, isVisited, board, row, column, row + 1, column);
        }

        if (column - 1 >= 0) {
            getNext(result, isVisited, board, row, column, row, column - 1);
        }

        if (column + 1 < board[0].length) {
            getNext(result, isVisited, board, row, column, row, column + 1);
        }

        return result;
    }

    private void getNext(List<int[][]> result, Set<String> isVisited,
                         int[][] board, int fromRow, int fromColumn,
                         int toRow, int toColumn) {

        int[][] next = {board[0].clone(), board[1].clone()};

        int temp = next[fromRow][fromColumn];
        next[fromRow][fromColumn] = next[toRow][toColumn];
        next[toRow][toColumn] = temp;

        String key = getKey(next);
        if (isVisited.add(key)) {
            result.add(next);
            if (isValid(next)) {
                return;
            }
        }
    }

    private String getKey(int[][] board) {
        StringBuilder key = new StringBuilder();

        for (int[] row: board) {
            for (int e: row) {
                key.append(e);
            }
        }

        return key.toString();
    }
}
