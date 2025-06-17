// Question: https://leetcode.com/problems/pass-the-pillow/description/

class PassThePillow {
    public int passThePillow(int n, int time) {
        boolean isIncrement = true;
        int current = 1;

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