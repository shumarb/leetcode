// Question: https://leetcode.com/problems/subsets-ii/description/

class SubsetsTwo {
    private List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean isTest = false;
        result = new ArrayList<>();

        nums = sort(nums);
        helper(new ArrayList<>(), nums, 0);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
            System.out.println("----------------------------\nresult:");
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

    private int[] sort(int[] nums) {
        int[] frequency = new int[21];
        int j = 0;

        for (int number: nums) {
            frequency[number + 10]++;
        }
        for (int i = 0; i <= 20; i++) {
            while (frequency[i]-- > 0) {
                nums[j++] = i - 10;
            }
        }

        return nums;
    }
}