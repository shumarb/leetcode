// Question: https://leetcode.com/problems/non-overlapping-intervals/description/

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        boolean isTest = false;
        int countNonOverlappingIntervals = 1; // Count first interval.
        int latestEndTime = 0;
        int totalIntervals = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        latestEndTime = intervals[0][1];
        for (int i = 1; i < totalIntervals; i++) {
            if (intervals[i][0] >= latestEndTime) {
                countNonOverlappingIntervals++;
                latestEndTime = intervals[i][1];
            }
        }
        if (isTest) {
            System.out.println("sorted intervals by end time (ascending):");
            for (int [] interval: intervals) {
                System.out.println(" * " + Arrays.toString(interval));
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println("totalIntervals: " + totalIntervals + "\ncountNonOverlappingIntervals: " + countNonOverlappingIntervals);
        }

        return totalIntervals - countNonOverlappingIntervals;
    }
}