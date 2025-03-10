// Question: https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/description/

class CheckIfTwoChessboardSquaresHaveTheSameColour {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        boolean isTest = false;

        int c1RowNumber = coordinate1.charAt(0) - 'a';
        int c1ColumnNumber = coordinate1.charAt(1) - '1';
        int c2RowNumber = coordinate2.charAt(0) - 'a';
        int c2ColumnNumber = coordinate2.charAt(1) - '1';
        if (isTest) {
            System.out.println("coordinate 1: " + coordinate1 + " | row: " + c1RowNumber + ", column: " + c1ColumnNumber);
            System.out.println("coordinate 2: " + coordinate2 + " | row: " + c1RowNumber + ", column: " + c2ColumnNumber);
            System.out.println("-----------------------------------------------------------------------------");
        }

        int[] c1Row = getRow(c1RowNumber);
        int[] c2Row = getRow(c2RowNumber);
        if (isTest) {
            System.out.println("c1Row:" + Arrays.toString(c1Row));
            System.out.println("c2Row:" + Arrays.toString(c2Row));
            System.out.println("-----------------------------------------------------------------------------");
        }

        return c1Row[c1ColumnNumber] == c2Row[c2ColumnNumber];
    }

    private int[] getRow(int rowNumber) {
        int[] oddRow = new int[] {1, 0, 1, 0, 1, 0, 1, 0};
        int[] evenRow = new int[] {0, 1, 0, 1, 0, 1, 0, 1};
        return rowNumber % 2 == 0 ? evenRow : oddRow;
    }
}