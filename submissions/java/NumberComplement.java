// Question: https://leetcode.com/problems/number-complement/description/

class NumberComplement {
    public int findComplement(int num) {
        boolean isTest = false;
        double complement = 0;
        int power = 0;

        while (num != 0) {
            int bit = num % 2;
            int reverseBit = 0;
            if (bit == 1) {
                reverseBit = 0;
            } else {
                reverseBit = 1;
            }

            if (reverseBit == 1) {
                complement += Math.pow(2.0, power);
            }

            power++;
            num /= 2;
        }
        if (isTest) {
            System.out.println("complement: " + complement);
        }

        return (int) complement;
    }
}