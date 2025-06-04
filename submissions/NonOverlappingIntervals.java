// Question: https://leetcode.com/problems/non-overlapping-intervals/description/

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        boolean isTest = false;
        int count = 0;
        int len = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        if (isTest) {
            System.out.println("sorted intervals (by end time):");
            for (int[] row: intervals) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("-----------------------------------------------");
        }

        /**
         1.  Given 2 intervals, exclude an interval when it's end time
             is less than the start time of latest interval counted.
             When no overlap occurs, set previous end time as most-recently-counted interval's end time,
             and repeat comparison for remaining intervals.
         */
        int previousEndTime = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] < previousEndTime) {
                if (isTest) {
                    System.out.println(" * exclude: " + Arrays.toString(intervals[i]));
                }
                count++;
            } else {
                previousEndTime = intervals[i][1];
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------");
            System.out.println("count: " + count);
        }

        return count;
    }
}