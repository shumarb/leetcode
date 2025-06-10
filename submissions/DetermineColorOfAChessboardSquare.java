// Question: https://leetcode.com/problems/determine-color-of-a-chessboard-square/description/

class DetermineColorOfAChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        boolean isTest = false;
        int column = coordinates.charAt(0) - 'a' + 1;
        int row = coordinates.charAt(1) - '0';

        if (isTest) {
            System.out.println("coordinates: " + coordinates + " | column: " + column + " | row: " + row);
        }

        /**
         1.  Square colour is determined by 1-based sum of row and column integer values,
             If the sum is odd, the square is white, else it is black.
         */
        return (row + column) % 2 == 1;
    }
}