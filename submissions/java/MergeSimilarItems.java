// Question: https://leetcode.com/problems/merge-similar-items/description/

class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> result = new ArrayList<>();
        int[] map = new int[1001];

        for (int[] entry: items1) {
            map[entry[0]] += entry[1];
        }
        for (int[] entry: items2) {
            map[entry[0]] += entry[1];
        }

        for (int i = 1; i <= 1000; i++) {
            if (map[i] > 0) {
                result.add(List.of(i, map[i]));
            }
        }

        return result;
    }
}