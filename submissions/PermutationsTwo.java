// Question: https://leetcode.com/problems/permutations-ii/description/

class PermutationsTwo {
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(), nums);

        return result;
    }

    private void dfs(int currentIndex, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[currentIndex]);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(i, path, nums);
            path.removeLast();
        }
    }
}