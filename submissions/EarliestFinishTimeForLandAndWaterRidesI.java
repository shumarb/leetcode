// Question: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/description/

class Solution {
    private int result;

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        result = Integer.MAX_VALUE;

        compute(landStartTime, landDuration, waterStartTime, waterDuration);
        compute(waterStartTime, waterDuration, landStartTime, landDuration);

        return result;
    }

    private void compute(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
        boolean isTest = false;
        for (int i = 0; i < firstStart.length; i++) {
            for (int j = 0; j < secondStart.length; j++) {
                int firstEnd = firstStart[i] + firstDuration[i];
                int secondBegin = Math.max(firstEnd, secondStart[j]);
                int secondEnd = secondBegin + secondDuration[j];

                if (isTest) {
                    System.out.println("first " + i + " -> second " + j + ": " + secondEnd);
                }

                result = Math.min(result, secondEnd);
            }
        }
    }
}
