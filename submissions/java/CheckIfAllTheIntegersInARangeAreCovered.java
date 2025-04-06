// Question: https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/description/

class CheckIfAllTheIntegersInARangeAreCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean isNumberInRange = false;
            for (int[] range: ranges) {
                if (i >= range[0] && i <= range[1]) {
                    isNumberInRange = true;
                    break;
                }
            }
            if (!isNumberInRange) {
                return false;
            }
        }
        return true;
    }
}