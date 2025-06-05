// Question: https://leetcode.com/problems/determine-color-of-a-chessboard-square/description/

class DetermineColorOfAChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        boolean isTest = false;

        // 1. Increase values by 1 given that coordinates are 1-based indexing.
        int rowNumber = coordinates.charAt(1) - '1' + 1;
        int columnNumber = coordinates.charAt(0) - 'a' + 1;
        boolean[] row = getRow(rowNumber);
        if (isTest) {
            System.out.println("coordinates: " + coordinates + " | rowNumber: " + rowNumber + ", columnNumber: " + columnNumber);
            System.out.println("row: " + Arrays.toString(row));
        }

        // 2. Decrease column number by 1 due to accessing index in array (0-based indexing).
        return row[columnNumber - 1];
    }

    private boolean[] getRow(int rowNumber) {
        boolean[] oddRow = new boolean[] {false, true, false, true, false, true, false, true};
        boolean[] evenRow = new boolean[] {true, false, true, false, true, false, true, false};
        return rowNumber % 2 == 0 ? evenRow : oddRow;
    }
}