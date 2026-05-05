// Question:

class TargetSum {
    private int[] nums;
    private int result;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        result = 0;
        this.nums = nums;
        this.target = target;

        dfs(new ArrayList<>(), 0, 0);

        return result;
    }

    private void dfs(List<Integer> path, int index, int sum) {
        boolean isTest = false;

        if (index >= nums.length) {
            if (sum == target) {
                if (isTest) {
                    System.out.println(" * path: " + path);
                }
                result++;
            }
            return;
        }

        path.add(nums[index]);
        dfs(path, index + 1, sum + nums[index]);
        path.removeLast();

        path.add(-nums[index]);
        dfs(path, index + 1, sum - nums[index]);
        path.removeLast();
    }
}
