// Question: https://leetcode.com/problems/count-servers-that-communicate/description/

class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        boolean isTest = false;
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        int[] countServersInColumns = new int[n];
        int[] countServersInRows = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    countServersInColumns[j]++;
                    countServersInRows[i]++;
                }
            }
        }
        if (isTest) {
            System.out.println("countServersInColumns:   " + Arrays.toString(countServersInColumns) + "\ncountServersInRows:      " + Arrays.toString(countServersInRows));
            System.out.println("--------------------------------------");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (countServersInColumns[j] > 1 || countServersInRows[i] > 1)) {
                    if (isTest) {
                        System.out.println(" * counted: [" + i + ", " + j + "]");
                    }
                    result++;
                }
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------\nresult: " + result);
        }

        return result;
    }
}
