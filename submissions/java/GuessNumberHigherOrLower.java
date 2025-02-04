// Question:

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left <= right) {
            int num = left + (right - left) / 2;
            if (guess(num) == 0) {
                return num;
            } else if (guess(num) == -1) {
                right = num - 1;
            } else {
                left = num + 1;
            }
        }

        return -1;
    }
}