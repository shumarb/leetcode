// Question: https://leetcode.com/problems/maximum-gap-between-stations/description/

class MaximumGapBetweenStations {
    public int maximumGap(String skill, String station) {
        boolean isTest = false;
        char[] skills = skill.toCharArray();
        char[] stations = station.toCharArray();
        int j = 0;
        int m = stations.length;
        int n = skills.length;
        int result = 0;
        int[] earliest = new int[n];
        int[] latest = new int[n];

        // 1. Find earliest and latest indices of mapping each character in skills to a an equal character in stations.
        for (int i = 0; i < n; i++) {
            while (skills[i] != stations[j]) {
                j++;
            }

            earliest[i] = j++;
        }

        j = m - 1;

        // 2. For every consecutive worker, compare the difference in distance between the first worker's earliest index (i - 1) and the second worker's latest index (j) to determine the maximum possible difference between the station indices.
        for (int i = n - 1; i > 0; i--) {
            while (skills[i] != stations[j]) {
                j--;
            }

            result = Math.max(result, j - earliest[i - 1]);
            latest[i] = j--;
        }
        if (isTest) {
            System.out.println("station:  " + Arrays.toString(stations) + "\nskills:   " + Arrays.toString(skills) + "\nearliest: " + Arrays.toString(earliest) + "\nlatest:   " + Arrays.toString(latest));
            System.out.println("----------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
