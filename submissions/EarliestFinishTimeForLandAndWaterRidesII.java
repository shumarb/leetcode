// Question: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/description/

class EarliestFinishTimeForLandAndWaterRidesII {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
                solve(landStartTime, landDuration, waterStartTime, waterDuration),
                solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    private int solve(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
        int finish1 = Integer.MAX_VALUE;
        int finish2 = Integer.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {
            finish1 = Math.min(finish1, firstStart[i] + firstDuration[i]);
        }
        for (int i = 0; i < secondStart.length; i++) {
            finish2 = Math.min(
                    finish2,
                    Math.max(finish1, secondStart[i]) + secondDuration[i]
            );
        }

        return finish2;
    }
}
