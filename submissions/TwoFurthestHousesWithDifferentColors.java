// Question: https://leetcode.com/problems/two-furthest-houses-with-different-colors/description/

class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        int left = 0;
        int n = colors.length;
        int result = Integer.MIN_VALUE;
        int right = n - 1;

        while (left < right) {
            if (colors[right] != colors[left]) {
                result = right - left;
                break;
            }
            right--;
        }

        left = 0;
        right = n - 1;
        while (left < right) {
            if (colors[right] != colors[left]) {
                result = Math.max(result, right - left);
                break;
            }
            left++;
        }

        return result;
    }
}
