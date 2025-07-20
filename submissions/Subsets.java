// Question:

class Subsets {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        boolean isTest = false;
        result = new ArrayList<>();

        helper(new ArrayList<>(), nums, 0);
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("result:");
            for (List<Integer> subset: result) {
                System.out.println(" * " + subset);
            }
        }

        return result;
    }

    private void helper(List<Integer> subset, int[] nums, int startIndex) {
        // 1. Subset at initial stage of helper is a valid subset, so add it to result.
        result.add(new ArrayList<>(subset));

        /**
         2.  From index startIndex to nums.length - 1,
             add i-th element to subset,
             then explore all subsets formed by adding (i + 1)th element,
             then backtrack.
         */
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(subset, nums, i + 1);
            subset.removeLast();
        }
    }
}