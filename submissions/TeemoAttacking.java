// Question: https://leetcode.com/problems/teemo-attacking/description/

class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalSeconds = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] < timeSeries[i] + duration) {
                totalSeconds += timeSeries[i + 1] - timeSeries[i];
            } else {
                totalSeconds += duration;
            }
        }

        // 1. Duration for last event.
        totalSeconds += duration;

        return totalSeconds;
    }
}