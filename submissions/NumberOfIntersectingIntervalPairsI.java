// Question: https://leetcode.com/problems/number-of-intersecting-interval-pairs-i/description/

class NumberOfIntersectingIntervalPairsI {
    public int countIntersectingIntervals(int[][] intervals) {
        boolean isTest = false;
        int m = intervals.length;
        int result = 0;

        if (isTest) {
            System.out.println("intervals:");
            for (int[] e: intervals) {
                System.out.println(Arrays.toString(e));
            }
            System.out.println("----------------------------------");
        }

        for (int i = 0; i < m; i++) {
            int[] first = intervals[i];
            for (int j = i + 1; j < m; j++) {
                int[] second = intervals[j];

                if (first[0] <= second[1] && second[0] <= first[1]) {
                    result++;
                    if (isTest) {
                        System.out.println(" * intersect: " + Arrays.toString(first) + ", " + Arrays.toString(second));
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("----------------------------------\nresult: " + result);
        }

        return result;
    }
}
