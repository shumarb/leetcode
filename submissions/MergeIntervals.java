// Question: https://leetcode.com/problems/merge-intervals/description/

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        result.add(intervals[0]);
        int[] current = intervals[0];
        for (int[] interval: intervals) {
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                result.add(interval);
                current = interval;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}