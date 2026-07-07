// Question: https://leetcode.com/problems/remove-covered-intervals/description/

class CoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        boolean isTest = false;
        int[] current;
        int n = intervals.length;
        int result = n;

        if (n == 1) {
            return n;
        }

        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a[0], b[0]) == 0
                        ? Integer.compare(b[1], a[1])
                        : Integer.compare(a[0], b[0])
        );
        if (isTest) {
            System.out.println("sorted intervals:");
            for (int[] e: intervals) {
                System.out.println(Arrays.toString(e));
            }
            System.out.println("---------------------------");
        }

        current = intervals[0];
        for (int i = 1; i < n; i++) {
            int[] incoming = intervals[i];
            if (incoming[1] <= current[1]) {
                result--;
                if (isTest) {
                    System.out.println(" * remove: " + Arrays.toString(incoming));
                }

            } else {
                current = incoming;
            }
        }
        if (isTest) {
            System.out.println("---------------------------\nresult: " + result);
        }

        return result;
    }
}
