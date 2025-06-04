// Question: https://leetcode.com/problems/check-if-it-is-a-straight-line/description/

class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] first = coordinates[0];
        int[] second = coordinates[1];
        int xDiff = second[0] - first[0];
        int yDiff = second[1] - first[1];

        for (int i = 2; i < coordinates.length; i++) {
            int[] current = coordinates[i];
            int currentXDiff = current[0] - first[0];
            int currentYDiff = current[1] - first[1];

            // 1. Check if coordinates are on same slope using cross product.
            if (yDiff * currentXDiff != xDiff * currentYDiff) {
                return false;
            }
        }

        return true;
    }
}