// Question: https://leetcode.com/problems/pass-the-pillow/description/

class PassThePillow {
    public int passThePillow(int n, int time) {
        int completedCycles = time / (n - 1);
        int remainder = time % (n - 1);
        return completedCycles % 2 == 1 ? n - remainder: remainder + 1;
    }
}