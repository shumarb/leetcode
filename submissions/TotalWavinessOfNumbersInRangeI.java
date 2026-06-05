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
        int last = number % 10;
        int result = 0;
        number /= 10;
        int current = number % 10;
        number /= 10;

        while (number > 0) {
            int next = number % 10;
            if ((current < last && current < next) || (current > last && current > next)) {
                result++;
            }
            last = current;
            current = next;
            number /= 10;
        }

        return result;
    }
}
