// Question: https://leetcode.com/problems/image-smoother/description/

class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        boolean isTest = false;
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        if (isTest) {
            print("img:", img);
        }

        // 1. Edge case: single row and single column.
        if (m == 1 && n == 1) {
            return img;
        }

        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                int count = 0;
                int sum = 0;

                for (int adjacentRow = row - 1; adjacentRow <= row + 1; adjacentRow++) {
                    for (int adjacentColumn = column - 1; adjacentColumn <= column + 1; adjacentColumn++) {
                        if (adjacentColumn >= 0 && adjacentColumn < n && adjacentRow >= 0 && adjacentRow < m) {
                            sum += img[adjacentRow][adjacentColumn];
                            count++;
                        }
                    }
                }
                if (isTest) {
                    System.out.println(" * [" + row + ", " + column + "] | element: " + img[row][column] + "  | sum: " + sum + ", count: " + count);
                }
                result[row][column] = sum / count;
            }
        }
        if (isTest) {
            print("------------------------------------------------------------\nresult:", result);
        }

        return result;
    }

    private void print(String s, int[][] grid) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------------------------------------------------");
    }
}
