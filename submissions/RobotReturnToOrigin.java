// Question: https://leetcode.com/problems/robot-return-to-origin/description/

class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        boolean isTest = false;
        int[] coordinates = new int[2];

        if (isTest) {
            System.out.println("moves: " + moves);
            System.out.println("before, coordinates: " + Arrays.toString(coordinates));
            System.out.println("----------------------------------------------------------");
        }
        for (char letter: moves.toCharArray()) {
            if (letter == 'U') {
                coordinates[0]++;
            } else if (letter == 'D') {
                coordinates[0]--;
            } else if (letter == 'L') {
                coordinates[1]--;
            } else {
                coordinates[1]++;
            }
        }
        if (isTest) {
            System.out.println("after, coordinates: " + Arrays.toString(coordinates));
            System.out.println("----------------------------------------------------------");
        }

        return coordinates[0] == 0 && coordinates[1] == 0;
    }
}