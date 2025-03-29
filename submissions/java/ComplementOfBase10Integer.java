// Question: https://leetcode.com/problems/complement-of-base-10-integer/description/

class ComplementOfBase10Integer {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        double complement = 0;
        int power = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                complement += Math.pow(2, power);
            }
            power++;
            n /= 2;
        }

        return (int) complement;
    }
}