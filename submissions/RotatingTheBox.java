// Question: https://leetcode.com/problems/rotating-the-box/description/

class RotatingTheBox class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        boolean isTest = false;
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] result = new char[n][m];

        int k = 0;
        for (int i = m - 1; i >= 0; i--) {
            char[] row = boxGrid[i];
            for (int j = 0; j < row.length; j++) {
                result[j][k] = row[j];
            }
            k++;
        }
        if (isTest) {
            print("boxGrid: ", boxGrid);
            print("before, result:", result);
        }

        m = result.length;
        n = result[0].length;
        for (int j = 0; j < n; j++) {
            int empty = m - 1;

            for (int i = m - 1; i >= 0; i--) {
                if (result[i][j] == '*') {
                    empty = i - 1;
                } else if (result[i][j] == '#') {
                    result[i][j] = '.';
                    result[empty--][j] = '#';
                }
            }
        }
        if (isTest) {
            print("after, result:", result);
        }

        return result;
    }

    private void print(String s, char[][] grid) {
        System.out.println(s);
        for (char[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----------------------------------");
    }
}
