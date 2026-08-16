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
        for (int i = n - 1; i >= 0; i--) {
            while (skills[i] != stations[j]) {
                j--;
            }

            latest[i] = j--;
        }
        if (isTest) {
            System.out.println("station:  " + Arrays.toString(stations) + "\nskills:   " + Arrays.toString(skills) + "\nearliest: " + Arrays.toString(earliest) + "\nlatest:   " + Arrays.toString(latest));
            System.out.println("----------------------------------------------------------------------------");
        }

        // 2. For every consecutive worker, compare the difference in distance between the first worker's earliest index and the second
        //    worker's latest index to determine the maximum possible difference between the station indices.
        for (int i = 0; i < n - 1; i++) {
            char first = skills[i];
            char second = skills[i + 1];
            int gap = latest[i + 1] - earliest[i];

            if (isTest) {
                System.out.println(" * indices: [" + i + ", " + (i + 1) + "] | letters: [" + first + ", " + second + "] | earliest-latest: [" + earliest[i] + ", " + latest[i + 1] + "] | gap: " + gap);
            }

            result = Math.max(gap, result);
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
