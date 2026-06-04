// Question: https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/

class TotalWavinessOfNumbersInRangeI {
    public int totalWaviness(int num1, int num2) {
        boolean isTest = false;
        int result = 0;

        num1 = Math.max(num1, 100);
        for (int i = num1; i <= num2; i++) {
            int waviness = countWaviness(i);
            if (waviness > 0) {
                if (isTest) {
                    System.out.println(" * " + i + ": " + waviness);
                }
            }
            result += waviness;
        }

        return result;
    }

    private int countWaviness(int number) {
        char[] digits = Integer.toString(number).toCharArray();
        int n = digits.length;
        int result = 0;

        for (int i = 1; i < n - 1; i++) {
            if (
                    (digits[i] > digits[i - 1] && digits[i] > digits[i + 1])
                            || (digits[i] < digits[i - 1] && digits[i] < digits[i + 1])
            ) {
                result++;
            }
        }

        return result;
    }
}
