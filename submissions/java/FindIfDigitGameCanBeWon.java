// Question: https://leetcode.com/problems/find-if-digit-game-can-be-won/description/

class FindIfDigitGameCanBeWon {
    public boolean canAliceWin(int[] nums) {
        int sumTotal = 0;
        int sumSingleDigitNumbers = 0;
        boolean isTest = false;

        for (int number: nums) {
            sumTotal += number;
            if (number < 10) {
                sumSingleDigitNumbers += number;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("sumTotal: " + sumTotal + ", sumSingleDigitNumbers: " + sumSingleDigitNumbers);
        }

        return sumSingleDigitNumbers != (sumTotal - sumSingleDigitNumbers);
    }
}