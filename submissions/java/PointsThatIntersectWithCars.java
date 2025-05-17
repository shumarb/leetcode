// Question: https://leetcode.com/problems/points-that-intersect-with-cars/description/

class PointsThatIntersectWithCars {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] isNumberPresent = new boolean[101];
        int len = isNumberPresent.length;
        int numberOfPoints = 0;
        for (List<Integer> entry: nums) {
            for (int i = entry.get(0); i <= entry.get(1); i++) {
                isNumberPresent[i] = true;
            }
        }
        for (int i = 1; i <= 100; i++) {
            if (isNumberPresent[i]) {
                numberOfPoints++;
            }
        }
        return numberOfPoints;
    }
}