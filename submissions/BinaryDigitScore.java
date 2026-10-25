// Question: https://leetcode.com/problems/binary-digit-score/description/

class BinaryDigitScore {
    public int calculateScore(int a, int b) {
        int s1 = countSetBits(a);
        int s2 = countSetBits(b);

        return s1 >= s2 ? s1 * s2 : s2 / s1;
    }

    private int countSetBits(int n) {
        int result = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                result++;
            }

            n /= 2;
        }

        return result;
    }
}
