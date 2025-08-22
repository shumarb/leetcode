// Question: https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/description/

class FindTheWidthOfColumnsOfAGrid {
    public int[] findColumnWidth(int[][] grid) {
        boolean isTest = false;
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];

        for (int j = 0; j < n; j++) {
            int longestWidth = Integer.MIN_VALUE;
            if (isTest) {
                System.out.println("j: " + j);
            }
            for (int i = 0; i < m; i++) {
                int currentWidth = getWidth(grid[i][j]);
                if (isTest) {
                    System.out.println(" * number: " + grid[i][j] + " -> width: " + currentWidth);
                }
                if (currentWidth > longestWidth) {
                    longestWidth = currentWidth;
                }
            }
            if (isTest) {
                System.out.println(" ** longestWidth: " + longestWidth);
                System.out.println("---------------------------------------");
            }
            result[j] = longestWidth;
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private int getWidth(int n) {
        int nCopy = n;
        int width = 0;

        if (n == 0) {
            width = 1;

        } else {
            if (n < 0) {
                width++;
                nCopy *= -1;
            }

            while (nCopy != 0) {
                width++;
                nCopy /= 10;
            }
        }

        return width;
    }
}