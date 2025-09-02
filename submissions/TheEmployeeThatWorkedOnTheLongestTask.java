// Question: https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/description/

class TheEmployeeThatWorkedOnTheLongestTask {
    public int hardestWorker(int n, int[][] logs) {
        boolean isTest = false;
        int[] map = new int[logs.length];
        map[0] = logs[0][1];
        int longest = map[0];
        int longestId = 0;

        for (int i = 1; i < logs.length; i++) {
            map[i] = logs[i][1] - logs[i - 1][1];
            if (map[i] > longest) {
                longest = map[i];
                longestId = i;
            } else if (map[i] == longest && logs[i][0] < logs[longestId][0]) {
                longestId = i;
            }
        }
        if (isTest) {
            System.out.println("map: " + Arrays.toString(map) + "\nlongestId: " + longestId);
            System.out.println("longest: " + longest + "\nresult: " + logs[longestId][0]);
        }

        return logs[longestId][0];
    }
}