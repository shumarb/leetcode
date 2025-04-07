// Question: https://leetcode.com/problems/merge-intervals/description/

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];
        result.add(current);

        for (int[] interval: intervals) {
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}