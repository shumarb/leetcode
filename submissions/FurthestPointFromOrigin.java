// Question: https://leetcode.com/problems/furthest-point-from-origin/description/

class FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        boolean isTest = false;
        int countNetSteps = 0;
        int countUnderscore = 0;

        for (char c: moves.toCharArray()) {
            if (c == 'L') {
                countNetSteps++;

            } else if (c == 'R') {
                countNetSteps--;

            } else {
                countUnderscore++;
            }
        }
        if (isTest) {
            System.out.println("countNetSteps: " + countNetSteps + ", countUnderscore: " + countUnderscore);

        }

        return Math.abs(countNetSteps) + countUnderscore;
    }
}
