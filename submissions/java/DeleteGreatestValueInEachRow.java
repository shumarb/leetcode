// Question: https://leetcode.com/problems/delete-greatest-value-in-each-row/description/

class DeleteGreatestValueInEachRow {
    public int deleteGreatestValue(int[][] grid) {
        int result = 0;

        for (int[] row: grid) {
            Arrays.sort(row);
        }
        for (int i = 0; i < grid[0].length; i++) {
            int maximum = Integer.MIN_VALUE;
            for (int[] row: grid) {
                maximum = Math.max(maximum, row[i]);
            }
            result += maximum;
        }

        return result;
    }
}