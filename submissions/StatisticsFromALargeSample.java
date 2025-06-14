// Question: https://leetcode.com/problems/statistics-from-a-large-sample/description/

class StatisticsFromALargeSample {
    public double[] sampleStats(int[] count) {
        boolean isTest = false;
        double maximum = Integer.MIN_VALUE;
        double mean = 0;
        double median = 0;
        double minimum = Integer.MAX_VALUE;
        double mode = 0;
        double totalCount = 0;
        int len = count.length;
        int maximumFrequency = 0;

        for (int i = 0; i < len; i++) {
            if (count[i] > 0) {
                maximum = Math.max(maximum, i);
                minimum = Math.min(minimum, i);
                mean += ((double) i * (double) count[i]);
                totalCount += count[i];
                if (count[i] > maximumFrequency) {
                    mode = i;
                    maximumFrequency = count[i];
                }

            }
        }
        mean /= totalCount;
        if (maximum == Integer.MIN_VALUE) {
            maximum = 0;
        }
        if (minimum == Integer.MAX_VALUE) {
            minimum = 0;
        }

        double m1 = -1;
        double m2 = -1;
        int countSoFar = 0;
        long mid1 = (long) (totalCount + 1) / 2;
        long mid2 = (long) (totalCount + 2) / 2;

        for (int i = 0; i < len; i++) {
            countSoFar += count[i];
            if (m1 == -1 && countSoFar >= mid1) {
                m1 = i;
            }
            if (m2 == -1 && countSoFar >= mid2) {
                m2 = i;
                break;
            }
        }
        median = (m1 + m2) / 2.0;

        return new double[] {minimum, maximum, mean, median, mode};
    }
}