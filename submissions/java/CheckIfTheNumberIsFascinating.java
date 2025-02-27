// Question: https://leetcode.com/problems/check-if-the-number-is-fascinating/description/

class CheckIfTheNumberIsFascinating {
    public boolean isFascinating(int n) {
        boolean isTest = false;
        int[] digitFrequency = new int[10];

        for (int i = 1; i <= 3; i++) {
            int value = n * i;
            String nStr = String.valueOf(value);
            for (char digit: nStr.toCharArray()) {
                digitFrequency[Character.getNumericValue(digit)]++;
            }
            if (isTest) {
                System.out.println("originalN: " + value + ", nStr: " + nStr + " digitFrequency: " + Arrays.toString(digitFrequency));
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