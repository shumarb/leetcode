// Question: https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/

class FindOccurrencesOfAnElementInAnArray {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;
        int[] result = new int[queries.length];

        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                list.add(i);
            }
        }

        // 1. Edge case: x is absent in nums.
        if (list.isEmpty()) {
            return result;
        }

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            if (query <= list.size()) {
                result[i] = list.get(query - 1);
            }
        }
        if (isTest) {
            System.out.println("list: " + list + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}