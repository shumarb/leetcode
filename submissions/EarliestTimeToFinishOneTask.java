// Question: https://leetcode.com/problems/earliest-time-to-finish-one-task/description/

class EarliestTimeToFinishOneTask {
    public int earliestTime(int[][] tasks) {
        int earliestTime = tasks[0][0] + tasks[0][1];

        for (int i = 1; i < tasks.length; i++) {
            earliestTime = Math.min(earliestTime, tasks[i][0] + tasks[i][1]);
        }

        return earliestTime;
    }
}