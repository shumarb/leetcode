// Question: https://leetcode.com/problems/available-captures-for-rook/description/

class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        boolean isTest = false;
        int count = 0;
        int rookX = -1;
        int rookY = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'R') {
                    rookX = i;
                    rookY = j;
                    break;
                }
            }
        }
        if (isTest) {
            System.out.println("board:");
            for (char[] row: board) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("----------------------");
            System.out.println("rook: [" + rookX + ", " + rookY + "]");
        }

        // 1. Left.
        for (int i = rookY - 1; i >= 0; i--) {
            if (board[rookX][i] == 'B') {
                break;

            } else if (board[rookX][i] == 'p') {
                if (isTest) {
                    System.out.println(" * counted: " + board[rookX][i]);
                }
                count++;
                break;
            }
        }

        // 2. Right.
        for (int i = rookY + 1; i < board.length; i++) {
            if (board[rookX][i] == 'B') {
                break;

            } else if (board[rookX][i] == 'p') {
                if (isTest) {
                    System.out.println(" * counted: " + board[rookX][i]);
                }
                count++;
                break;
            }
        }

        // 3. Up.
        for (int i = rookX - 1; i >= 0; i--) {
            if (board[i][rookY] == 'B') {
                break;

            } else if (board[i][rookY] == 'p') {
                if (isTest) {
                    System.out.println(" * counted: " + board[i][rookY]);
                }
                count++;
                break;
            }
        }

        // 4. Down.
        for (int i = rookX + 1; i < board[0].length; i++) {
            if (board[i][rookY] == 'B') {
                break;

            } else if (board[i][rookY] == 'p') {
                if (isTest) {
                    System.out.println(" * counted: " + board[i][rookY]);
                }
                count++;
                break;
            }
        }
        if (isTest) {
            System.out.println("----------------------\ncount: " + count);
        }

        return count;
    }
}