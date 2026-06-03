// Question: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/description/

class EarliestFinishTimeForLandAndWaterRidesI {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
                solve(landStartTime, landDuration, waterStartTime, waterDuration),
                solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    private int solve(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
        int minimumFirstFinishTime = Integer.MAX_VALUE;
        int minimumSecondFinishTime = Integer.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {
            minimumFirstFinishTime = Math.min(
                    minimumFirstFinishTime,
                    firstStart[i] + firstDuration[i]
            );
        }
        for (int i = 0; i < secondStart.length; i++) {
            minimumSecondFinishTime = Math.min(
                    minimumSecondFinishTime,
                    Math.max(minimumFirstFinishTime, secondStart[i]) + secondDuration[i]
            );
        }

        return minimumSecondFinishTime;
    }
}
