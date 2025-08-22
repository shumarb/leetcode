// Question: https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/description/

class FindTheWidthOfColumnsOfAGrid {
    public int[] findColumnWidth(int[][] grid) {
        boolean isTest = false;
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];

        for (int j = 0; j < n; j++) {
            if (isTest) {
                System.out.println("j: " + j);
            }

            int longestWidth = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                int current = grid[i][j];
                int currentWidth = 0;

                if (current == 0) {
                    currentWidth = 1;
                } else {
                    while (current != 0) {
                        currentWidth++;
                        current /= 10;
                    }
                    if (grid[i][j] < 0) {
                        currentWidth++;
                    }
                }
                if (isTest) {
                    System.out.println(" * number: " + grid[i][j] + " -> width: " + currentWidth);
                }

                longestWidth = Math.max(currentWidth, longestWidth);
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
}