// Question: https://leetcode.com/problems/furthest-point-from-origin/description/

class FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        boolean isTest = false;
        int countUnderscore = 0;
        int netSteps = 0;

        for (char c: moves.toCharArray()) {
            if (c == 'R') {
                netSteps++;
            } else if (c == 'L') {
                netSteps--;
            } else {
                countUnderscore++;
            }
        }
        if (isTest) {
            System.out.println("netSteps: " + netSteps + "\ncountUnderscore: " + countUnderscore);
        }

        if (netSteps == 0) {
            return Math.abs(countUnderscore);
        }

        return netSteps < 0 ? Math.abs(netSteps - countUnderscore) : netSteps + countUnderscore;
    }
}
