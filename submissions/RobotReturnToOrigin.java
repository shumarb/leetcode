// Question: https://leetcode.com/problems/robot-return-to-origin/description/

class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int[] frequency = new int[26];
        for (char letter: moves.toCharArray()) {
            frequency[letter - 'A']++;
        }
        return frequency['U' - 'A'] == frequency['D' - 'A']
                && frequency['L' - 'A'] == frequency['R' - 'A'];
    }
}