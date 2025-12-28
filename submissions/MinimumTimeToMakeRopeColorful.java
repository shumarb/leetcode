// Question: https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/

class MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        int maxTime = 0;
        int result = 0;

        for (int i = 0; i < colors.length(); i++) {
            // 1. Reset maxTime for start of new group.
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                maxTime = 0;
            }
            result += Math.min(maxTime, neededTime[i]);
            maxTime = Math.max(maxTime, neededTime[i]);
        }

        return result;
    }
}