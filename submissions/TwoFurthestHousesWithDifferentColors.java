// Question: https://leetcode.com/problems/two-furthest-houses-with-different-colors/description/

class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        int maximumDifference = 0;
        for (int i = 0; i < colors.length - 1; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    maximumDifference = Math.max(maximumDifference, j - i);
                }
            }
        }
        return maximumDifference;
    }
}