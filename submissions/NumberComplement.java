// Question: https://leetcode.com/problems/number-complement/description/

class NumberComplement {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }

        double complement = 0;
        int power = 0;

        while (num != 0) {
            if (num % 2 == 0) {
                complement += Math.pow(2, power);
            }
            power++;
            num /= 2;
        }

        return (int) complement;
    }
}