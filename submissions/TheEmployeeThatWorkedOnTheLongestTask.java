// Question: https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/description/

class TheEmployeeThatWorkedOnTheLongestTask {
    public int hardestWorker(int n, int[][] logs) {
        boolean isTest = false;
        int logWithLongestTask = 0;
        int longestTask = logs[0][1];

        for (int i = 1; i < logs.length; i++) {
            int currentTask = logs[i][1] - logs[i - 1][1];
            if (currentTask > longestTask || currentTask == longestTask && logs[i][0] < logs[logWithLongestTask][0]) {
                logWithLongestTask = i;
                longestTask = currentTask;
            }
        }
        if (isTest) {
            System.out.println("logWithLongestTask: " + logWithLongestTask);
            System.out.println("longestTask: " + longestTask + "\nemployee id: " + logs[logWithLongestTask][0]);
        }

        return logs[logWithLongestTask][0];
    }
}