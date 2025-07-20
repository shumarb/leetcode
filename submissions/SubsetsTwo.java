// Question: https://leetcode.com/problems/subsets-ii/description/

class SubsetsTwo {
    private List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean isTest = false;
        result = new ArrayList<>();

        Arrays.sort(nums);
        helper(new ArrayList<>(), nums, 0);
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("-------------------------\nresult:");
            for (List<Integer> subset: result) {
                System.out.println(subset);
            }
        }

        return result;
    }

    private void helper(List<Integer> subset, int[] nums, int index) {
        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            /**
             1.  Skip current element if it is the
                 the first element of an earlier subset
                 that has been added to result.
             */
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(subset, nums, i + 1);
            subset.removeLast();
        }
    }
}