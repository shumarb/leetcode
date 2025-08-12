// Question: https://leetcode.com/problems/non-decreasing-subsequences/description/

class NonDecreasingSubsequences {
    private List<List<Integer>> result;
    private int[] nums;

    private boolean isValid(List<Integer> path) {
        for (int i = 1; i < path.size(); i++) {
            if (path.get(i) < path.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    private void helper(int startIndex, List<Integer> path) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        Set<Integer> isCounted = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 1. Ensure path is non-decreasing.
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                continue;
            }

            // 2. Skip duplicates.
            if (isCounted.contains(nums[i])) {
                continue;
            }

            isCounted.add(nums[i]);
            path.add(nums[i]);
            helper(i + 1, path);
            isCounted.remove(nums[i]);
            path.removeLast();
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        boolean isTest = true;
        int len = nums.length;
        result = new ArrayList<>();
        this.nums = nums;

        helper(0, new ArrayList<>());
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("result:");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }
}