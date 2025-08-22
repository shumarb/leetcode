// Question: https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/description/

class FindTheWidthOfColumnsOfAGrid {
    private boolean isTest = false;

    public int[] findColumnWidth(int[][] grid) {
        int k = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];

        for (int j = 0; j < n; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                list.add(grid[i][j]);
            }
            if (isTest) {
                System.out.println("---------------------------------------");
                System.out.println("j: " + j + ", list: " + list);;
            }
            result[k++] = getWidth(list);
        }
        if (isTest) {
            System.out.println("---------------------------------------");
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private int getWidth(List<Integer> list) {
        int longestWidth = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            int currentWidth = getWidth(list.get(i));
            if (currentWidth > longestWidth) {
                longestWidth = currentWidth;
            }
        }
        if (isTest) {
            System.out.println(" ** longestWidth: " + longestWidth);
        }

        return longestWidth;
    }

    private int getWidth(int n) {
        boolean isNegative = true;
        int nCopy = n;
        int width = 0;

        if (n <= 0) {
            width = 1;
            if (n == 0) {
                if (isTest) {
                    System.out.println(" * n: " + n + " -> width: " + width);
                }
                return width;
            }
            isNegative = true;
            nCopy *= -1;
        }

        while (nCopy > 0) {
            width++;
            nCopy /= 10;
        }
        if (isTest) {
            System.out.println(" * n: " + n + " -> width: " + width);
        }

        return width;
    }
}