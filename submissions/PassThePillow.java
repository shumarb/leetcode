// Question: https://leetcode.com/problems/pass-the-pillow/description/

class PassThePillow {
    public int passThePillow(int n, int time) {
        boolean isIncrement = true;
        int completedCycles = 2 * (n - 1);
        int current = 1;

        /**
         1.  Modulo divide time by number of completed cycles
             to reduce number of checks.
         */
        time %= completedCycles;

        while (time-- > 0) {
            if (isIncrement) {
                current++;
            } else {
                current--;
            }
            if (current == n) {
                isIncrement = false;
            } else if (current == 1) {
                isIncrement = true;
            }
        }

        return current;
    }
}