// Question: https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/

class FindOccurrencesOfAnElementInAnArray {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean isTest = false;
        int[] result = new int[queries.length];

        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.computeIfAbsent(key, value -> new ArrayList<>()).add(i);
        }

        // 1. Edge case: x is absent in nums.
        if (!map.containsKey(x)) {
            return result;
        }

        List<Integer> value = map.get(x);
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] <= value.size()) {
                result[i] = value.get(queries[i] - 1);
            }
        }
        if (isTest) {
            System.out.println("map: " + map + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}