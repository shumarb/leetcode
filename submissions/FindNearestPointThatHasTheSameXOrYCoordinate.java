// Question: https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/description/

class FindNearestPointThatHasTheSameXOrYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        boolean isTest = false;
        int index = Integer.MAX_VALUE;
        int n = points.length;
        int smallestManhattanDistance = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int xPoint = point[0];
            int yPoint = point[1];
            if (xPoint == x || yPoint == y) {
                int manhattanDistance = Math.abs(xPoint - x) + Math.abs(yPoint - y);
                if (isTest) {
                    System.out.println(" * valid: " + Arrays.toString(point) + " -> manhattanDistance: " + manhattanDistance);
                }

                if (manhattanDistance < smallestManhattanDistance) {
                    index = i;
                    smallestManhattanDistance = manhattanDistance;
                }
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------\nindex: " + index);
        }

        return index == Integer.MAX_VALUE ? -1 : index;
    }
}