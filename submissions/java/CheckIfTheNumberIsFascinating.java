// Question: https://leetcode.com/problems/check-if-the-number-is-fascinating/description/

class CheckIfTheNumberIsFascinating {
    public boolean isFascinating(int n) {
        int[] digitFrequency = new int[10];

        for (int i = 1; i <= 3; i++) {
            int value = n * i;
            while (value != 0) {
                digitFrequency[value % 10]++;
                value /= 10;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (digitFrequency[i] != 1) {
                return false;
            }
        }

        return true;
    }
}