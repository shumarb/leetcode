// Question: https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/

class MergeTwo2DArraysBySummingValues {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int countEntries = 0;
        int[] map = new int[1001];
        int[][] result;

        for (int[] entry: nums1) {
            if (map[entry[0]] == 0) {
                countEntries++;
            }
            map[entry[0]] += entry[1];
        }
        for (int[] entry: nums2) {
            if (map[entry[0]] == 0) {
                countEntries++;
            }
            map[entry[0]] += entry[1];
        }

        result = new int[countEntries][];
        int k = 0;
        for (int i = 1; i <= 1000; i++) {
            if (map[i] > 0) {
                result[k++] = new int[] {i, map[i]};
            }
        }

        return result;
    }
}