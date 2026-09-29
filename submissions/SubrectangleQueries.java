// Question: https://leetcode.com/problems/subrectangle-queries/description/

class SubrectangleQueries {
    private boolean isTest;
    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        isTest = false;
        this.rectangle = rectangle;
        if (isTest) {
            print("---------------------------------------\ninitial:");;
        }
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if (isTest) {
            print("---------------------------------------\nupdate | row1: " + row1 + ", col1: " + col1 + ", row2: " + row2 + ", col2: " + col2 + ", newValue: " + newValue + "\n\nbefore:");
        }
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
        if (isTest) {
            print("\nafter:");
        }
    }

    public int getValue(int row, int col) {
        int result = rectangle[row][col];
        if (isTest) {
            print("---------------------------------------\ngetValue | row: " + row + ", col: " + col + "\n\nrectangle:");
            System.out.println("\nresult: " + result);
        }

        return result;
    }

    private void print(String s) {
        System.out.println(s);
        for (int[] row: rectangle) {
            System.out.println(Arrays.toString(row));
        }
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
