// Question: https://leetcode.com/problems/make-a-square-with-the-same-color/description/

class MakeASquareWithTheSameColor {
    private boolean canMakeSquare(int i, int j, char[][] grid) {
        boolean isTest = false;
        int countBlack = 0;
        int countWhite = 0;

        if (grid[i][j] == 'B') {
            countBlack++;
        } else {
            countWhite++;
        }

        if (grid[i][j + 1] == 'B') {
            countBlack++;
        } else {
            countWhite++;
        }

        if (grid[i + 1][j] == 'B') {
            countBlack++;
        } else {
            countWhite++;
        }

        if (grid[i + 1][j + 1] == 'B') {
            countBlack++;
        } else {
            countWhite++;
        }

        if (isTest) {
            System.out.println("------------------------");
            System.out.println("grid[" + i + ", " + j + "]: " + grid[i][j]);
            System.out.println("grid[" + i + ", " + (j + 1) + "]: " + grid[i][j + 1]);
            System.out.println("grid[" + (i + 1) + ", " + j + "]: " + grid[i + 1][j]);
            System.out.println("grid[" + (i + 1) + ", " + (j + 1) + "]: " + grid[i + 1][j + 1]);
            System.out.println(" * countBlack: " + countBlack + "\n * countWhite: " + countWhite);
        }

        return (countBlack == 3 && countWhite == 1) || (countBlack == 1 && countWhite == 3)
                || (countBlack == 4 && countWhite == 0) || (countBlack == 0 && countWhite == 4);
    }

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (canMakeSquare(i, j, grid)) {
                    return true;
                }
            }
        }

        return false;
    }
}