// Question: https://leetcode.com/problems/determine-color-of-a-chessboard-square/description/

class DetermineColorOfAChessboardSquare class Solution {
    public boolean squareIsWhite(String coordinates) {
        boolean isTest = false;
        int column = coordinates.charAt(0) - 'a' + 1;
        int row = coordinates.charAt(1) - '0';

        if (isTest) {
            System.out.println("coordinates: " + coordinates + " | column: " + column + " | row: " + row);
        }

        return (row + column) % 2 != 0;
    }
}