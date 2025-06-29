// Question: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int currentSum = 0;
        int len = cardPoints.length;
        int minimumWindowSum = 0;
        int total = 0;
        int windowSize = len - k;

        for (int point: cardPoints) {
            total += point;
        }

        /**
         1.  To identify k-sized window of maximum points,
             identify (len - k)-sized window of miinimum points to remove using sliding window
             and deducting it from total.
         */
        for (int i = 0; i < windowSize; i++) {
            currentSum += cardPoints[i];
        }
        minimumWindowSum = currentSum;
        for (int i = windowSize; i < len; i++) {
            currentSum += (cardPoints[i] - cardPoints[i - windowSize]);
            minimumWindowSum = Math.min(minimumWindowSum, currentSum);
        }

        return total - minimumWindowSum;
    }
}