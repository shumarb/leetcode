// Question: https://leetcode.com/problems/maximum-number-of-balls-in-a-box/description/

class MaximumNumberOfBallsInABox {
    public int countBalls(int lowLimit, int highLimit) {
        int[] sumOfDigitsFrequency = new int[46];
        boolean isTest = false;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sumOfDigits = computeSumOfDigits(i);
            sumOfDigitsFrequency[sumOfDigits]++;
        }

        if (isTest) {
            System.out.println("lowLimit: " + lowLimit + "\nhighLimit: " + highLimit);
            System.out.println("sumOfDigitsFrequency: " + Arrays.toString(sumOfDigitsFrequency));
        }

        int maximumBallsCount = 0;
        for (int ballCount: sumOfDigitsFrequency) {
            maximumBallsCount = Math.max(maximumBallsCount, ballCount);
        }
        if (isTest) {
            System.out.println("maximum ball count: " + maximumBallsCount);
        }

        return maximumBallsCount;
    }

    private int computeSumOfDigits(int number) {
        int sumOfDigits = 0;
        while (number != 0) {
            sumOfDigits += (number % 10);
            number /= 10;
        }
        return sumOfDigits;
    }
}