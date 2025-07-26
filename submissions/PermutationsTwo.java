// Question: https://leetcode.com/problems/permutations-ii/description/

class PermutationsTwo {
    private List<List<Integer>> result;
    private int len;

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean isTest = false;
        Arrays.sort(nums);
        len = nums.length;
        result = new ArrayList<>();

        dfs(new ArrayList<>(), nums, new boolean[len]);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
            System.out.println("---------------------------\nresult:");
            for (List<Integer> list: result) {
                System.out.println(list);
            }
        }

        return result;
    }

    private void dfs(List<Integer> path, int[] nums, boolean[] isIndexUsed) {
        if (path.size() == len) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            // 1. Skip used indices to ensure no checking of duplicate paths.
            if (isIndexUsed[i]) {
                continue;
            }

            // 2. Skip duplicate elements.
            if (i > 0 && !isIndexUsed[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }

            // 3. Explore path and backtrack.
            isIndexUsed[i] = true;
            path.add(nums[i]);
            dfs(path, nums, isIndexUsed);
            isIndexUsed[i] = false;
            path.removeLast();
        }
    }
}