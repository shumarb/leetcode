// Question: https://leetcode.com/problems/points-that-intersect-with-cars/description/

class PointsThatIntersectWithCars {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] isNumberPresent = new boolean[101];
        int len = isNumberPresent.length;
        int numberOfPoints = 0;

        for (List<Integer> entry: nums) {
            for (int i = entry.get(0); i <= entry.get(1); i++) {
                if (!isNumberPresent[i]) {
                    isNumberPresent[i] = true;
                    numberOfPoints++;
                }
            }
        }

        return numberOfPoints;
    }
}