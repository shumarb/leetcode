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

        Arrays.fill(earliest, -1);
        Arrays.fill(latest, -1);
        for (int i = 0; i < n; i++) {
            while (stations[j] != skills[i]) {
                j++;
            }

            earliest[i] = j++;
        }
        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (stations[j] != skills[i]) {
                j--;
            }
            latest[i] = j--;
        }

        for (int i = 0; i < n - 1; i++) {
            result = Math.max(latest[i + 1] - earliest[i], result);
        }
        if (isTest) {
            System.out.println("earliest: " + Arrays.toString(earliest) + "\nlatest: " + Arrays.toString(latest) + "\nresult: " + result);
        }


        return result;
    }
}
