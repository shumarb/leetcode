// Question: https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/description/

class CheckIfTwoChessboardSquaresHaveTheSameColour {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        boolean isTest = false;
        int column1 = coordinate1.charAt(0) - 'a' + 1;
        int column2 = coordinate2.charAt(0) - 'a' + 1;
        int row1 = coordinate1.charAt(1) - '0';
        int row2 = coordinate2.charAt(1) - '0';

        if (isTest) {
            System.out.println("coordinate1: " + coordinate1 + " | column1: " + column1 + ", row1: " + row1);
            System.out.println("coordinate2: " + coordinate2 + " | column2: " + column2 + ", row2: " + row2);
        }

        return (row1 + column1 + row2 + column2) % 2 == 0;
    }
}